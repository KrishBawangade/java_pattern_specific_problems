package greedy_approach;

public class JumpGame1 {
    public static boolean canJump(int[] nums) {
        int maxJump = 0;
        for(int i=0; i<nums.length; i++){
            
            if(maxJump<i){
                return false;
            }

            maxJump = Math.max(maxJump, i+nums[i]);

            if(maxJump>=nums.length-1){
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args){
        int[] nums = {3,2,1,0,4};

        System.out.println(canJump(nums));
    }
}
