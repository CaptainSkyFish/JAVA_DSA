public class backtrack{

    public static void changeVal(int[] arr, int idx, int val){
        if(idx == arr.length){
            printArr(arr);
            return;
        }
        arr[idx] = val;
        changeVal(arr, idx+1, val+1);
        arr[idx] -= 2;
    }

    public static void printArr(int array[]){
        for(int i : array)
            System.out.print(i+"\t");
            System.out.println();
    }

    public static void printSubsets(String s, int idx, String ogStr){
        if(idx == ogStr.length()){
            if(s.length() == 0)
                System.out.println("null");
            else
                System.out.println(s);
            return;
        }
        printSubsets(s+ogStr.charAt(idx), ++idx, ogStr);
        printSubsets(s, idx, ogStr);
    }

    public static void permute(String s, String ogS){
        if(ogS.length()==0){
            System.out.println(s);
            return;
        }
        for(int i = 0; i < ogS.length(); i++){
            String newStr = ogS.substring(0, i) + ogS.substring(i+1);       //reduces the length of original string by deleting the character that has been used
            permute(s+ogS.charAt(i), newStr);
        }
    }

    public static void printBoard(char[][] board){
        System.out.println("--------New board--------");
        for(char row[]: board){
            for(char ch: row)
                System.out.print(ch + "  ");
            System.out.println();
        }
    }
    public static void resetBoard(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                board[i][j] = 'X';
            }
        }
    }
    public static boolean isSafe(char[][] board, int row, int col){     //program to check the safety of queen
        for(int i= row-1; i>=0; i--){         //vertical up
            if(board[i][col] == 'Q')
                return false;
        }
        for(int i= row-1, j= col-1; i>=0 && j>=0; i--, j--){       //diagonally left
            if(board[i][j] == 'Q')
                return false;
        }
        for(int i= row-1, j = col+1; i>=0 && j<board.length; i--, j++){       //diagonally right
            if(board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public static void nQueens(char[][] board, int row){        //program to place N queens in a N X N chessboard 
        if(row == board.length){
            printBoard(board);
            return;
        }
        for(int i=0; i<board.length; i++){
            if(isSafe(board, row, i)){
                board[row][i] = 'Q';
                nQueens(board, row+1);
                board[row][i] = 'X';
            }
        }
    }

    public static int gridWays(int strtRow, int strtCol, int m, int n){
        if(strtRow == (m-1) && strtCol == (n-1))
            return 1;
        else if(strtRow == m || strtCol == n)
            return 0;
        
        int w1 = gridWays(strtRow+1, strtCol, m, n);
        int w2 = gridWays(strtRow, strtCol+1, m, n);

        return w1+w2;
    }

    public static void main(String[] args){
        int arr[] = new int[5];
        changeVal(arr, 0, 12);
        printArr(arr);
        printSubsets("", 0, "abc");
        permute("", "abc");
        char[][] board = new char[6][6];
        resetBoard(board);
        nQueens(board, 0);
        System.out.println(gridWays(0,0,3,3));
    }
}
