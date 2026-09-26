package stacks;

import java.util.*;

public class NextGreaterElement1 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int num: nums2){

            while(!stack.isEmpty() && stack.peek() < num){
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }

        for(int i=0; i<nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }

        return res;
    } 

    public static void main(String[] args){
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] res = nextGreaterElement(nums1, nums2);

        System.out.println(Arrays.toString(res));
    }
}
