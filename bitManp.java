// import java.util.Arrays;

public class bitManp{

    static void OddorEven(int n){
        int bitMask = 1;
        if((n & bitMask) == 1){
            System.out.println("Odd");
        }
        else{
            System.out.println("Even");
        }
    }

    public static int getIthBit(int n, int i){
        int bitMask = 1<<i;
        if((n & bitMask) == 0)
            return 0;
        else 
            return 1;
    }
    
    public static int setIthBit(int n, int i){
        int bitMask = 1<<i;
        return n|bitMask;
    }

    public static int clearIthBit(int n, int i){
        int bitMask = 1<<i;
        return ~bitMask & n;
    }

    public static int clearAndSet(int n, int i, int newBit){
        n = clearIthBit(n, i);
        int bitMask = newBit<<i;
        return n | bitMask;
    }

    public static int clearLast(int n, int i){
        int bitMask = -1<<i;                            // (~0) = -1
        return n & bitMask;
    }

    public static int clrRange(int n, int i, int j){
        int a = (~0)<<(j+1);
        int b = (1<<i)-1;                               //1<<i = 1*(2^i)
        int bitMask = a | b;
        return bitMask & n;
    }

    public static boolean isPowerofTwo(int n){
        if((n & (n-1)) == 0)
            return true;
        else
            return false;
    }

    public static int countSetB(int n){
        int count = 0;
        while(n > 0){
            if((n & 1) == 1)    count++;                //if LSB = 1 odd . else LSB = 0 even
            n = n>>1;
        }
        return count;
        
    }

    public static int AddNumsB(int a, int b){
        if(b == 0)
            return a;
        else
            return AddNumsB(a^b, (a&b)<<1);
    }

    public static void RotateBits(int n, int d){
        int right_rot = n >> d | n << (32-d);                   //gives n/2^d
        int left_rot = n << d | n >> (32-d);                    //gives n*2^d
        System.out.println(right_rot + "\t" + left_rot);
    }

    public static void SwapNumsB(int a, int b){
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a + "," + b);
    }

    public static char[] changeCase(char a[]){
        for(int i=0; i < a.length; i++){
            if(a[i] >= 97)
                a[i] &= ~32;
            else
                a[i] |= 32;
        }
        return a;
    }

    public static int FastExpo(int a, int n){
        int ans = 1;
        while(n > 0){
            if ((n&1) == 1){
                ans = ans*a;
            }
            n = n>>1;
            a = a*a;
        }
        return ans;
    }

    public static int AddOne(int n){
        return (-(~n));                                        //-n is stored as ~n+1 in the memory called two's complement
    }

    public static void main(String[] args){
        OddorEven(354659);
        System.out.println(getIthBit(15, 3));
        System.out.println(setIthBit(8, 2));
        System.out.println(clearIthBit(10, 1));
        System.out.println(clearAndSet(7, 3, 1));
        System.out.println(clearLast(31, 2));
        System.out.println(clrRange(25, 2 , 4));
        System.out.println(isPowerofTwo(6));
        System.out.println(countSetB(16));
        System.out.println(AddNumsB(-20, 145));
        System.out.println("Bit Rotation: ");    RotateBits(64, 2);
        System.out.println("Numbers Swapped(16,45): ");    SwapNumsB(16, 45);
        System.out.println(FastExpo(2, 5));
        System.out.println(changeCase("aJaYbIr sInGh".toCharArray()));
        System.out.println(AddOne(0));
    }
}