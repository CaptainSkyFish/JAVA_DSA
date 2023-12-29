public class twoDMat {

    public static void printSpiral(int a[][]){
        int SR = 0;
        int ER = matrix.length-1;
        int SC = 0;
        int EC = matrix[0].length-1;

        while(SR <= ER && SC <= EC){

            for(int i=SC; i<=EC; i++){
                System.out.print(a[SR][j] + " ");
            }

            for(int i=SR+1; i<=ER; i++){
                System.out.print(a[i][ER] + " ");
            }

            for(int i=EC-1; i>=0; i--){
                System.out.print(a[ER][i] + " ");
            }

            for(int i=ER-1; i>0; i--){
                System.out.print(a[i][SC] + " ");
            }
        }
    }

    public static void main(){
        int matrix[][] = {{2, 4, 6}, {8, 10, 12}, {14, 16, 18}};
        printSpiral();
    }
    
}
