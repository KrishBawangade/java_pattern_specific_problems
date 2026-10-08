package greedy_approach;

public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGasCount = 0;
        int minSum = 0;
        int start = 0;

        for(int i=0; i<gas.length; i++){
            totalGasCount+= gas[i] - cost[i];

            if(totalGasCount<minSum){
                minSum = totalGasCount;
                start = i+1;
            }
        }

        return totalGasCount<0? -1: start;
    }

    public static void main(String[] args){
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};   

        System.out.println(canCompleteCircuit(gas, cost));
    }
}
