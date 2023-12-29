

public class arrays{

    public static int lin_srch(int a[], int n){
        for(int i=0;i<a.length;i++){
            if(a[i]==n)
            return i;
        }
        return -1;
    }


    public static int lrgst(int a[]){
        int lrgst=Integer.MIN_VALUE;                        // Integer.MIN_VALUE    &     Integer.MAX_VALUE used for positive and negative infinity
        for(int i=0;i<a.length;i++){
            if(a[i]>lrgst)
            lrgst=a[i];
        }
        return lrgst;
    }


    public static int bin_srch(int a[], int key){
        int mid, f=0, l=a.length;
        for(int i=0;i<a.length;i++){
            mid=(f+l)/2;
            if(a[mid]==key)
            return mid;
            else if(a[mid]>key)
            l=mid;
            else
            f=mid;
        }
        return -1;
    }


    public static void reverse(int a[]){
        int f=0, l=a.length-1;

        for(int i=0;i<a.length;i++){
            while(f<l){
            a[f]=a[f]+a[l];
            a[l]=a[f]-a[l];
            a[f]=a[f]-a[l];

            f++;l--;
            }
            
        }
    }

    
    public static void printPairs(int a[]){
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                System.out.print("("+a[i]+","+a[j]+")");
            }
            System.out.println();
        }
    }

    public static void printSubArray(int a[]){
        // int max=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                // int s=0;
                for(int k=i;k<=j;k++){
                System.out.print(a[k]+" ");
                // s+=a[k];
            }
            // if(s>=max)
            // max=s;
            System.out.println();
        }
        System.out.println();
        }
    // return max;
    }

    public static int getSumSubArray(int a[]){

        int prefAr[]=new int[a.length];             //creating prefix Array
        prefAr[0]=a[0];
        for(int i=1; i<a.length; i++){
            prefAr[i]=prefAr[i-1]+a[i];
        }

        int currSum=0, maxSum=
        
        Integer.MIN_VALUE;

        for(int i=0; i<a.length; i++){              //calculating max sum of a subarray
            for(int j=i; j<a.length; j++){
                currSum=i==0 ? prefAr[j] : prefAr[j]-prefAr[i-1];

                if(currSum>maxSum)
                maxSum=currSum;
            }
        }

        return maxSum;
    }

    public static int kadanes(int num[]){               
        int MaxSum = Integer.MIN_VALUE, MaxElement = Integer.MIN_VALUE;
        int CurrSum=0, start = 0, end = 0;
        for(int i = 0; i < num.length; i++){
            if((CurrSum + num[i]) < 0){
                CurrSum = 0;
                start = i+1;
            }
            else{
                CurrSum += num[i];
            }
            if(CurrSum > MaxSum){
                MaxSum = CurrSum;
                end = i;
            }
            MaxElement = Math.max(MaxElement, num[i]);
            //CurrSum = Math.max(num[i] + CurrSum, 0);              //if the current sum turns out to be negative, replace it by 0
            //MaxSum = Math.max(CurrSum, MaxSum);
        }
        System.out.println("The subarray with max sum is:");
        while(start<=end){
            System.out.print(num[start]+"\t");
            ++start;
        }
        if(MaxSum == 0)
            return MaxElement;
        else
            return MaxSum;
        
    }


    public static void main(String[] args){
        int a[]={50,07,80,10,5,6,21};
        int l_index=lin_srch(a,7);
        if(l_index==-1)
        System.out.println("Not Found");
        else
        System.out.println("Index of required integer is: "+l_index);
        int l=lrgst(a);
        System.out.println("The largest integer in array is: "+l);

        int b_index=bin_srch(a,6);
        if(b_index==-1)
        System.out.println("Not Found");
        else
        System.out.println("Index of required integer is: "+b_index);

        reverse(a);
        System.out.println("Array in reverse order is:");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();

        System.out.println("All possible pairs of array are: ");
        printPairs(a);

        System.out.println("All possible subarrays of the given array are:");
        printSubArray(a);

        int ar[] = {-2, 1, 4, -3, 5, -6};
        int max=getSumSubArray(ar);
        System.out.println("Maximum sum of a subarray from the given array is(using prefix method): "+max);
        System.out.println("\nMaximum sum of a subarray from the given array is(using kadanes): "+ kadanes(ar));
    }
}