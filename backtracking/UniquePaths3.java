package backtracking;

public class UniquePaths3 {

    public static int uniquePathsIII(int[][] grid) {
        int[] res = findStartEmpty(grid);
        int startRow = res[0];
        int startCol = res[1];
        int count = res[2];

        return uniquePath(grid, startRow, startCol, startRow, startCol, count);
    }

    private static int uniquePath(int[][] grid, int startRow, int startCol, int row, int col, int count){

        //block has obstacle
        if(grid[row][col] == -1){
            return 0;
        }

        //target reached
        if(grid[row][col] == 2){
            return count == -1? 1: 0;
        }

        int original = grid[row][col];

        // mark as visited
        grid[row][col] = 1;

        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;

        if(col-1>=0 && grid[row][col-1] != 1){
            left = uniquePath(grid, startRow, startCol, row, col-1, count-1);
        }

        if(col+1<grid[row].length && grid[row][col+1] != 1){
            right = uniquePath(grid, startRow, startCol, row, col+1, count-1);
        }

        if(row-1>=0 && grid[row-1][col] != 1){
            up = uniquePath(grid, startRow, startCol, row-1, col, count-1);
        }

        if(row+1<grid.length && grid[row+1][col] != 1){
            down = uniquePath(grid, startRow, startCol, row+1, col, count-1);
        }

        
        //backtrack
        grid[row][col] = original;

        return left+right+up+down;
    }

    private static int[] findStartEmpty(int[][] grid){
        int count = 0;
        int startRow =-1;
        int startCol = -1;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    startRow = i;
                    startCol = j;
                }

                if(grid[i][j] == 0){
                    count++;
                }
            }
        }

        return new int[]{startRow, startCol, count};
    }


    public static void main(String[] args){
        int[][] grid = {
            {1,0,0,0},
            {0,0,0,0},
            {0,0,2,-1}
        };

        System.out.println(uniquePathsIII(grid));
    }
}
