package binary_search;

public class ShipPackagesWithinDays {
    
    public static int shipWithinDays(int[] weights, int days) {
        int low = weights[0];
        int high = weights[0];

        for(int i=1; i<weights.length; i++){
            low = Math.max(low, weights[i]);
            high+=weights[i];
        }

        

        while(low<high){
            int mid = low + (high-low)/2;

            if(canShip(weights, days, mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }

        return low;
    }

    private static boolean canShip(int[] weights, int days, int capacity){
        int currWeight = 0;
        int requiredDays = 1;

        for(int weight: weights){
            if(currWeight+weight > capacity){
                requiredDays++;
                currWeight = 0;
            }

            currWeight+=weight;
        }

        return requiredDays<=days;
    }

    public static void main(String[] args){
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println(shipWithinDays(weights, days));
    }
}
