package k_way_merge;

import java.util.*;

public class FindKPairsSmallestSums {

    static class Pair{

        int i;
        int j;

        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> smallestPairs = new ArrayList<>();
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
            (a, b) -> {
                int sum1 = nums1[a.i] + nums2[a.j];
                int sum2 = nums1[b.i] + nums2[b.j];

                return Integer.compare(sum1, sum2);
            }
        );

        // add pair 1 from each row of combinations
        for(int i=0; i<Math.min(nums1.length, k); i++){
            minHeap.add(new Pair(i,0));
        }

        int count = 0;

        while(count != k && !minHeap.isEmpty()){
            Pair smallest = minHeap.poll();
            int i = smallest.i;
            int j = smallest.j;

            smallestPairs.add(new ArrayList<>(Arrays.asList(nums1[i], nums2[j])));

            if(j<nums2.length-1){
                minHeap.add(new Pair(i,j+1));
            }
            count++;
        }

        return smallestPairs;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;

        System.out.println(kSmallestPairs(nums1, nums2, k));
    }
}
