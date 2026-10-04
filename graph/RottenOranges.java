package graph;

import java.util.*;

public class RottenOranges {

    static class Pos{
        int row;
        int col;

        Pos(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static int orangesRotting(int[][] grid) {
        int freshCount = 0;
        ArrayList<Pos> rottenOranges = new ArrayList<>();

        int time = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    freshCount++;
                }

                if(grid[i][j] == 2){
                    rottenOranges.add(new Pos(i, j));
                }
            }
        }

        if(freshCount == 0){
            return 0;
        }

        Queue<Pos> queue= new ArrayDeque<>();
        
        for(Pos rottenOrange: rottenOranges){
            queue.add(rottenOrange);
        }

        while(!queue.isEmpty() && freshCount != 0){
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                Pos orange = queue.poll();

                int row = orange.row;
                int col = orange.col;

                //down
                if(row+1<grid.length && grid[row+1][col] == 1){
                    queue.add(new Pos(row+1, col));
                    grid[row+1][col] = 2;
                    freshCount--;
                }

                //up
                if(row-1>=0 && grid[row-1][col] == 1){
                    queue.add(new Pos(row-1, col));
                    grid[row-1][col] = 2;
                    freshCount--;
                }

                //left
                if(col-1>=0 && grid[row][col-1] == 1){
                    queue.add(new Pos(row, col-1));
                    grid[row][col-1] = 2;
                    freshCount--;
                }

                //right
                if(col+1<grid[row].length && grid[row][col+1] == 1){
                    queue.add(new Pos(row, col+1));
                    grid[row][col+1] = 2;
                    freshCount--;
                }
            }

            time++;
        }

        return freshCount == 0? time: -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };

        System.out.println(orangesRotting(grid));
    }
}
