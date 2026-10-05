package dijkstra;

import java.util.*;

public class NetworkDelayTime {

    static class Pair{
        int node;
        int distance;

        Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, ArrayList<int[]> > adjacencyMap = new HashMap<>();
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
            (a,b) -> {
                return Integer.compare(a.distance, b.distance);
            }
        );

        minHeap.add(new Pair(k, 0));

        int[] finalPath = new int[n];

        Arrays.fill(finalPath, Integer.MAX_VALUE);
        finalPath[k-1] = 0;

        // creating the adjacency map
        for(int[] time: times){
            ArrayList<int[]> adjacencyList= adjacencyMap.getOrDefault(time[0], new ArrayList<>());
            adjacencyList.add(time);
            adjacencyMap.put(time[0], adjacencyList);
        }

        while(!minHeap.isEmpty()){
            Pair pair = minHeap.poll();
            
            if(pair.distance != finalPath[pair.node-1]){
                continue;
            }

            ArrayList<int[]> adjacentList = adjacencyMap.getOrDefault(pair.node, new ArrayList<>());

            for(int[] adjacentPair: adjacentList){
                int v = adjacentPair[1];
                int w = adjacentPair[2];

                int newDistance = pair.distance+w;

                if(newDistance<finalPath[v-1]){
                    finalPath[v-1] = newDistance;
                    minHeap.add(new Pair(v, finalPath[v-1]));
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for(int distance: finalPath){
            if(distance == Integer.MAX_VALUE){
                return -1;
            }

            max = Math.max(max, distance);
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] times = {
            {1,2,1},
        };
        int n=4;
        int k=2;

        System.out.println(networkDelayTime(times, n, k));
    }
}
