package heaps;

import java.util.*;

public class KthSmallestElementMatrix {

    static class Element{
        int num;
        int row;
        int col;

        Element(int num, int row, int col){
            this.num = num;
            this.row = row;
            this.col = col;
        }
    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>(
            (a,b) -> {
                return Integer.compare(a.num, b.num);
            }
        );

        for(int i=0; i<matrix.length; i++){
            minHeap.add(new Element(matrix[i][0], i, 0));
        }

        int count = 0;

        while(count != k-1){
            Element ele = minHeap.poll();
            int row = ele.row;
            int col = ele.col;
            
            if(col < matrix[row].length-1){
                minHeap.add(new Element(matrix[row][col+1], row, col+1));
            }

            count++;
        }

        return minHeap.poll().num;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;

        System.out.println(kthSmallest(matrix, k));
    }
}
