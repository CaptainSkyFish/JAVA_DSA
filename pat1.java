import java.util.*;
public class pat1 {
    public static void hollow_rect(int r, int c)
    {
         for(int i=1;i<=r;i++)
         {
            for(int j=1;j<=c;j++)
            {
                if(i==1||i==r||j==1||j==c)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
                }
                System.out.println();
         }
    }

    public static void main(String[] args)
    {
        Scanner aj=new Scanner(System.in);
        System.out.println("Enter the number of rows and columns resp. ");
        int r=aj.nextInt();
        int c=aj.nextInt();
        hollow_rect(r,c);
        aj.close();
    }
}