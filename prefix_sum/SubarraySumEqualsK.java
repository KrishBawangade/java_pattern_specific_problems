package prefix_sum;

import java.util.*;

public class SubarraySumEqualsK {
    
    public static int subarraySum(int[] nums, int k) {

        int n = nums.length;

        int count = 0;

        HashMap<Integer, Integer> freq = new HashMap<>();
        int currSum = 0;

        freq.put(currSum, 1);

        for(int i=0; i<n; i++){
            currSum += nums[i];

            if(freq.containsKey(currSum - k)){
                count+=freq.get(currSum-k);
            }

            freq.put(currSum, freq.getOrDefault(currSum, 0)+1);
        }

        return count;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        int k=3;

        System.out.println(subarraySum(nums, k));
    }
}
