package two_pointers;

public class ContainerMostWater{

    public static int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;

        int maxArea = 0;

        while(i<j){
            int w = j-i;
            int h = Math.min(height[i], height[j]);

            maxArea = Math.max(maxArea, w * h);

            if(height[i]>height[j]){
                j--;
            }else{
                i++;
            }
        }

        return maxArea;
    }

    public static void main(String[] args){

        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(height));
    }
}