class TrapRW{

    public static int bruteforce(int[] nums){
        int lmax[] = new int[nums.length];
        lmax[0] = nums[0];
        int rmax[] = new int[nums.length];
        rmax[nums.length-1] = nums[nums.length-1];

        for(int i = 1; i < nums.length; i++){                           //auxiliary array to calculate left boundary for every element
                lmax[i] = Math.max(nums[i], lmax[i-1]);
        }

        for(int i = nums.length-2; i >=0; i--){                         //auxiliary array to calculate right boundary for every element
            rmax[i] = Math.max(nums[i], rmax[i+1]);
        }

        int trap = 0;
        for(int i = 0; i < nums.length; i++){
            int WaterLevel = Math.min(lmax[i], rmax[i]);
            trap += WaterLevel-nums[i]; 
        }
        return trap;
    }

    public static int optimized(int[] nums){
        int l=0, r = nums.length-1; 
        int lmax = nums[l], rmax = nums[r];
        int trap = 0;

        while(l < r){
            if(rmax < lmax){
                r--;
                rmax = Math.max(rmax, nums[r]);
                trap += rmax - nums[r];
            }
            else{
                l++;
                lmax = Math.max(lmax, nums[l]);
                trap += lmax-nums[l];
            }
        }
        return trap;
    }


public static void main(String args[]){
    int height[]={5,1,1,2,8,6,3};
    System.out.println(bruteforce(height));
    System.out.println(optimized(height));
}
}