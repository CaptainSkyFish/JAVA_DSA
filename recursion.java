public class recursion{
    public static boolean isSorted(int arr[], int i){
        if(i == arr.length-1){
            return true;
        }

        if(arr[i] < arr[i+1]){
            return false;
        }
        
        return isSorted(arr, i+1);
    }

    public static int firstOccur(int arr[], int key, int i){
        if(arr[i] == key){
            return i;
        }
        else if(i == arr.length-1){
            return -1;
        }
        return firstOccur(arr ,key ,i+1);
    }

    public static int lastOccur(int arr[], int key, int i){
        if(i == arr.length){
            return -1;
        }

        int isFound = lastOccur(arr, key, i+1);
        if(isFound == -1 && arr[i] == key){
            return i;
        }
        return isFound;
    }

    public static int pow(int x, int n){
        if(n == 0)
            return 1;
        
        int HlfPowSq = pow(x, n/2);
        if((n & 1) == 1)                        //odd power -n
            return x * HlfPowSq * HlfPowSq;
        
        return HlfPowSq * HlfPowSq;
    }

    public static int tile(int n){          //2*n -floor area
        if(n == 0 || n==1){
            return 1;
        }

        //int Ways = tile(n-1) + tile(n-2);           //vertically placed - tile(n-1) horizontally placed -tile(n-2)
        return tile(n-1) + tile(n-2);
    }

    public static void delDupes(String s, boolean map[], int idx, StringBuilder newStr){
        if(idx == s.length()){
            System.out.println(newStr);
            return;
        }
        
        if(map[s.charAt(idx) - 'a']){        
            delDupes(s, map, idx+1, newStr);            
        }
        else{
            map[s.charAt(idx) - 'a'] = true;
            delDupes(s, map, idx+1, newStr.append(s.charAt(idx))); 
        }
    }

    public static int pairMe(int n){
        if(n <= 2)
            return n;

        return pairMe(n-1) + (n-1) * pairMe(n-2);
    }

    public static void printBinStrings(int n, int lastPlace, StringBuilder s){
        if(n == 0){
            System.out.println(s);
            return;
        }

        printBinStrings(n-1, 0, s.append("0"));
        s.deleteCharAt(s.length() - 1);
        if(lastPlace == 0){
            printBinStrings(n-1, 1, s.append("1"));
            s.deleteCharAt(s.length() - 1);
        }
    }


    public static void printOccurances(int key, int arr[], int idx, int ans){
        if(idx < arr.length){
        if(arr[idx] == key){
            System.out.print(idx+"\t");
        }
        printOccurances(key, arr, ++idx, ans);
        }
        else{
            System.out.println();
            return;
        }
    }

    static String digits[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static void numberInWords(int num){
        if(num == 0){
            return;
        }
        
        numberInWords(num/10);
        System.out.print(digits[num%10] + "\t");    
    }

    public static int sLength(String s){
        if(s.length() == 0)
            return 0;

        return sLength(s.substring(1)) + 1;
    }

    public static int countContigSubs(String s, int si, int ei){
        if((ei-si+1)<= 0){
            return 0;
        }
        if((ei-si+1) == 1){
            return 1;
        }
        int count = countContigSubs(s, si, ei-1) + countContigSubs(s, si+1, ei) - countContigSubs(s, si+1, ei-1);
        
        if(s.charAt(si) == s.charAt(ei))
            count++;
        return count;
    }

    public static void TowerOfHanoi(){
        
    }

    public static void main(String[] args){
        int arr[] = {9, 1, 5, 3, 1, 3, 5, 1};
        System.out.println("The array is sorted: "+ isSorted(arr, 0));
        System.out.println(firstOccur(arr, 1, 0));
        System.out.println(lastOccur(arr, 1, 0));
        System.out.println(pow(2,15));
        System.out.println(tile(14));
        delDupes("aajjaAAyYYYbbiRRRRr".toLowerCase() , new boolean[26], 0, new StringBuilder(""));
        System.out.println(pairMe(4));
        printBinStrings(5, 0, new StringBuilder(""));
        printOccurances(1, arr, 0, 0);
        numberInWords(1947);
        System.out.println("\n" + sLength("aajjaAAyYYYbbiRRRRr"));
        System.out.println(countContigSubs("abcab", 0, 4));
    }
}