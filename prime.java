import java.util.*;
public class prime{
    
    public static boolean isPrime(int a){

        if(a==2){
            return true;
        }

        for(int i=2; i<=a-1; i++){
            if(a%i == 0){
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the limit:");
        int n=sc.nextInt();

        for(int i=2; i<=n; i++){
            if(isPrime(i)){
                System.out.print(i+" ");
            }
        }
        sc.close();
    }
}