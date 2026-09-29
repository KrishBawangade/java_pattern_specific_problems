package heaps;

import java.util.*;

public class TopKFrequent {

    public static class FreqPair{
        int num;
        int freq;

        FreqPair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        PriorityQueue<FreqPair> pq = new PriorityQueue<>(
            (a,b) -> {
                return Integer.compare(a.freq, b.freq);
            }
        );

        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            pq.add(new FreqPair(entry.getKey(), entry.getValue()));

            if(pq.size()>k){
                pq.poll();
            }
        }

        int[] topK = new int[k];

        int i=k-1;

        while(!pq.isEmpty()){
            topK[i] = pq.poll().num;
            i--;
        }

        return topK;

    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        int[] res = topKFrequent(nums, k);

        System.out.println(Arrays.toString(res));
    }
} 
