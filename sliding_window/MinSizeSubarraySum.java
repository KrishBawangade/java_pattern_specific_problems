package sliding_window;

public class MinSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;

        int minLen = nums.length+1;
        int currSum = 0;

        while(j<nums.length){
            currSum+=nums[j];

            while(currSum>=target){
                minLen = Math.min(minLen, j-i+1);
                currSum-=nums[i];
                i++;
            }

            j++;
        }

        return minLen == nums.length+1 ? 0: minLen;
    }

    public static void main(String[] args){
        int[] nums = {2,3,1,2,4,3};
        int target = 7;

        System.out.println(minSubArrayLen(target, nums));
    }
}
