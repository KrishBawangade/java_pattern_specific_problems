package prefix_sum;

import java.util.*;

public class ContinuousSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> remainderMap = new HashMap<>();

        int currSum = 0;

        remainderMap.put(0, -1);

        for(int i=0; i<n; i++){
            currSum+=nums[i];

            int remainder = currSum%k;

            if(remainderMap.containsKey(remainder) &&  i - remainderMap.get(remainder)>=2){
                return true;
            }

            if(!remainderMap.containsKey(remainder)){
                remainderMap.put(remainder, i);
            }
        }

        return false;
    }   

    public static void main(String[] args){
        int[] nums = {23,2,6,4,7};
        int k =13;

        System.out.println(checkSubarraySum(nums, k));
    }
}
