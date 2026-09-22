package merge_intervals;

import java.util.*;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();

        int i = 0;

        // 1. Add intervals that end before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. Merge overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Add the merged interval
        result.add(newInterval);

        // 3. Add remaining intervals
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args){
        int[][] intervals = {{1,3}, {6,9}};
        int[] newInterval = {2,5};

        int[][] updatedIntervals = insert(intervals, newInterval);

        for(int[] interval: updatedIntervals){
            System.out.print(Arrays.toString(interval)+" ");
        }
    } 
}
