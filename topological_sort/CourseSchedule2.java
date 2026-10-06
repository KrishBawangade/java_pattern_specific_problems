package topological_sort;

import java.util.*;

public class CourseSchedule2 {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        Map<Integer, ArrayList<Integer>> adjMap = new HashMap<>();

        // finding indegree for each course and generating adjacency map
        for(int[] prerequisite: prerequisites){
            indegree[prerequisite[0]]++;

            ArrayList<Integer> list = adjMap.getOrDefault(prerequisite[1], new ArrayList<>());

            list.add(prerequisite[0]);
            adjMap.put(prerequisite[1], list);
        }


        Queue<Integer> queue = new ArrayDeque<>();

        ArrayList<Integer> res = new ArrayList<>();

        // add courses in queue whose indegree == 0
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int course = queue.poll();
            res.add(course);

            for(int adj: adjMap.getOrDefault(course, new ArrayList<>())){

                indegree[adj]--;

                if(indegree[adj] == 0){
                    queue.add(adj);
                }
            }
        }

        //cycle present
        if(res.size() != numCourses){
            return new int[] {};
        }

        int[] order = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            order[i] = res.get(i);
        }

        return order;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0}, {2,0}, {3,1}, {3,2}};

        int[] order = findOrder(numCourses, prerequisites);

        System.out.println(Arrays.toString(order));
    }
}
