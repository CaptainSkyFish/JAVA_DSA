import java.util.*;
public class leap_year{
    public static void main(String[] args){
        Scanner aj=new Scanner(System.in);
        System.out.println("Enter the year to be checked");
        int y=aj.nextInt();

        boolean a= (y%4) == 0;
        boolean b= (y%100) !=0;
        boolean c= (y%100) == 0 && (y%400) == 0;
        if(a && (b||c))
        System.out.print("Leap Year");
        else
        System.out.print("Not a Leap Year");
        aj.close();
    }
}