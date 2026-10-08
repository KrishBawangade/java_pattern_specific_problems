package greedy_approach;

public class JumpGame2 {

    public static int jump(int[] nums) {
        int maxJump = 0;
        int steps=0;
        int currEnd = 0;

        for(int i=0; i<nums.length-1; i++){
            
            maxJump = Math.max(maxJump, i+nums[i]);

            if(currEnd == i){
                currEnd = maxJump;
                steps++;
            }
            

        }

        return steps;
    }
    public static void main(String[] args){
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};

        System.out.println(jump(nums));
    }
}
