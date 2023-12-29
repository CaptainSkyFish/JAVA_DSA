class backtrack2{
    static int maze[][] =  
    {{ 1, 0, 0, 0 },
     { 1, 1, 1, 1 },
     { 1, 1, 0, 1 },
     { 1, 1, 1, 1 }};
    public static void main(String[] args){
        int key[][] = new int[4][4];
        solveRatMaze(maze, 0, 0, key, 4, 4);
    }

    public static void printMaze(int[][] arr){
        for( int[] i : arr){
            for( int j: i){
                System.out.print(j+ "  ");
            }
            System.out.println();
        }System.out.println("-------new maze-------");
    }

    
    public static void solveRatMaze(int[][] maze, int m, int n, int[][] key, int row, int col){
        if(row-1 == m && col-1 == n)
        {
            key[m][n]=1;
            printMaze(key);
            key[m][n]=0;                        //Backtrack step to print next possible solution
            return;
        }
    
        //right
        if(m+1 < row && key[m+1][n]==0 && maze[m+1][n] == 1){
            key[m][n]=1;
            solveRatMaze(maze, m+1, n, key, row, col);
            key[m][n]=0;                                        //Backtrack to check for alternate paths (L/U/D)
        }
        //left
        if(m-1 >=0 && key[m-1][n]==0 && maze[m-1][n] == 1){
            key[m][n]=1;
            solveRatMaze(maze, m-1, n, key, row, col);
            key[m][n]=0;                                        //Backtrack to check for alternate paths (U/R/D)
        }
        //up
        if(n-1 >=0 && key[m][n-1]==0 && maze[m][n-1] == 1){
            key[m][n]=1;
            solveRatMaze(maze, m, n-1, key, row, col);
            key[m][n]=0;                                        //Backtrack to check for alternate paths (L/R/D)
        }
        //down
        if(n+1 < col && key[m][n+1]==0 && maze[m][n+1] == 1){
            key[m][n]=1;
            solveRatMaze(maze, m, n+1, key, row, col);
            key[m][n]=0;                                        //Backtrack to check for alternate paths (L/U/R)
        }
    }
}