class sudokuSolver{
    public static void main(String[] args){
        int[][] sudoku = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        solveSudoku(sudoku);
    }

    public static void print(int[][] sud){
        for(int i[] : sud){
            for(int j: i){
                System.out.print(j+"  ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] sudoku, int row, int col, int digit){
        int i,j;
        for(i=0; i<9; i++){
            if(sudoku[i][col] == digit || sudoku[row][i] == digit)      //checks if the digit is used in same column or row
                return false;
        }

        int sr= row - row % 3;                          //formula for starting row
        int sc= col - col % 3;                             //and starting column
        for(i= sr; i< sr+3; i++){                                       //checks if the digit is used in same box
            for(j = sc; j < sc+3; j++){
                if(sudoku[i][j] == digit)
                    return false;
            }
        }

        return true;
    }

    public static void solveSudoku(int[][] sud){
        SolutionCounter count = new SolutionCounter();
        solve(sud, count);
        System.out.println("Total Solutions: " + count.getCount());
    }

    public static void solve(int[][] sudoku, SolutionCounter count){
        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){

                if(sudoku[row][col] == 0){
                    for(int digit=1; digit<10; digit++){
                        if(isSafe(sudoku, row, col, digit)){
                            sudoku[row][col] = digit;
                            solve(sudoku, count);
                            sudoku[row][col] = 0;
                        }
                    }
                    return;

                }
            }
        }
        count.increment();
        print(sudoku);
    }

}

class SolutionCounter {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }
}