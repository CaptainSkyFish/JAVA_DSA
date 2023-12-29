
class test {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String st = reversealpha(s);
        int i=0;
        while( i <= st.length()-1-i){
                if( st.charAt(i) != st.charAt(st.length()-1-i) ){
                return false;
                }
            i++;
        }

        return true; 
    }


public static String reversealpha(String st){
    String str="";
    int i = st.length()-1;
    while(i >= 0){
        if(Character.isAlphabetic(st.charAt(i)) || Character.isDigit(st.charAt(i)))
        str += st.charAt(i);
        i--;
    }
    return str;
}


public static void bubbleSort(int[] arr){
    for(int i=0; i<arr.length; i++){
        for(int j=0; j<arr.length-1-i; j++){
            if(arr[j]>arr[j+1])
            arr[j] = arr[j] + arr[j+1]  - (arr[j] = arr[j+1]);
        }
    }
    
}

    public static void main(String[] args){
        // System.out.println(isPalindrome("A man, a plan,, a canal: Panama"));
        
        // System.out.println(reversealpha("0P"));
        System.out.println(~(-10));
        int a = (int)Math.ceil( 5.0/3);
        System.out.println(a);
        int arr[] ={9,8,7,6,5,4,3,2,1,0};
        bubbleSort(arr);
        for(int i: arr){
            System.out.print(arr[i]+"\t");
        }
    }

}