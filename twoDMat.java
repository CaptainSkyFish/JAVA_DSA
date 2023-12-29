public class twoDMat {

    public static void printSpiral(int a[][]){
        int SR = 0;
        int ER = a.length-1;
        int SC = 0;
        int EC = a[0].length-1;

        while(SR <= ER && SC <= EC){

            for(int i=SC; i<=EC; i++){                      //top
                System.out.print(a[SR][i] + " ");
            }

            for(int i=SR+1; i<=ER; i++){                    //right
                System.out.print(a[i][EC] + " ");
            }

            for(int i=EC-1; i>=SC; i--){                    //bottom
                if(SR == ER)
                    break;
                System.out.print(a[ER][i] + " ");
            }

            for(int i=ER-1; i>=SR+1; i--){                  //left
                if(SC==EC)
                    break;
                System.out.print(a[i][SC] + " ");
            }

            SC++;
            SR++;
            ER--;
            EC--;
        }
    }

    public static void printDiagonalSum(int a[][]){             //most optimized code
        int sum=0;
        for(int i=0; i<a.length; i++){
            sum += a[i][i];
            if(i != a.length-1-i){
                sum += a[i][a.length-1-i];
            }
        }

        System.out.print("\n" + sum);

    }

    public static boolean StaircaseSrch(int m[][], int key){
        int r = m.length-1; int c = 0;
        while (c < m.length && r>=0){
            if(key == m[r][c]){
                System.out.println("Key found at: "+ r + "," + c);
                return true;
            }

            else if (key < m[r][c]){
                r--;
            }
            else{
                c++;
            }
        }
        System.out.println("Key not found!");
        return false;
    }

    public static void main(String[] args){
        int matrix[][] = {{2,   4,  6, 7}, 
                          {8,  10, 12, 13}, 
                          {14, 16, 18, 19},
                          {20, 22, 24, 25}};
        printSpiral(matrix);
        printDiagonalSum(matrix);

        int key = 13;
        System.out.println(StaircaseSrch(matrix, key));
    }
    
}
