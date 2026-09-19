package prefix_sum;

public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {

        if(nums.length == 0){
            return -1;
        }

        int n = nums.length;

        int[] prefix = new int[n];

        prefix[0] = nums[0];

        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        for(int i=0; i<n; i++){
            if((i==0) && (prefix[n-1] - prefix[0]) == 0){
                return i;
            }

            if((i==n-1) && prefix[i-1] == 0){
                return i;
            }

            if(i==0 || i== n-1){
                continue;
            }

            int left = prefix[i-1];
            int right = prefix[n-1] - prefix[i];

            if(left == right){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] nums = {1,7,3,6,5,6};

        System.out.println(pivotIndex(nums));
    }
}
