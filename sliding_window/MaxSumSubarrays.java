package sliding_window;

import java.util.*;

public class MaxSumSubarrays{

    public static long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long windowSum = 0;

        int distinct = 0;

        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i=0; i<nums.length; i++){

            freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);

            if(freq.get(nums[i]) == 1){
                distinct++;
            }

            windowSum+=nums[i];

            if(i>=k){
                windowSum-=nums[i-k];
                int left = freq.get(nums[i-k]);

                if(left == 1){
                    distinct--;
                    freq.remove(nums[i-k]);
                }else{
                    freq.put(nums[i-k], left-1);
                }

            }

            if(i>=k-1 && distinct == k){
                maxSum = Math.max(maxSum, windowSum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,4,2,9,9,9};
        int k = 3;

        System.out.println(maximumSubarraySum(nums, k));
    }
}