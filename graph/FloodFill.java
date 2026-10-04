package graph;

import java.util.*;

public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];

        if(original == color){
            return image;
        }

        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[] { sr, sc });
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int row = pos[0];
            int col = pos[1];

            // add down
            if (row + 1 < image.length && image[row + 1][col] == original) {
                queue.add(new int[] { row + 1, col });

                // change color
                image[row+1][col] = color;
            }

            // add up
            if (row - 1 >= 0 && image[row - 1][col] == original) {
                queue.add(new int[] { row - 1, col });

                // change color
                image[row-1][col] = color;
            }

            // add left
            if (col - 1 >= 0 && image[row][col - 1] == original) {
                queue.add(new int[] { row, col - 1 });

                // change color
                image[row][col-1] = color;
            }

            // add right
            if (col + 1 < image[row].length && image[row][col + 1] == original) {
                queue.add(new int[] { row, col + 1 });

                // change color
                image[row][col+1] = color;
            }
        }

        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };
        int sr = 1;
        int sc = 1;
        int color = 2;

        floodFill(image, sr, sc, color);

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
