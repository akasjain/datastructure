package leetcode.challenge.may;

import java.util.*;

public class C29_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0)
            return true;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] edge: prerequisites) {
            graph.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[numCourses];
        Set<Integer> dfsPath = new HashSet<>();

        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]) {
                if(!dfs(i, graph, visited, dfsPath)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited, Set<Integer> dfsPath) {
        // if node is present in current dfs path then it comes in a cycle
        if(dfsPath.contains(node))
            return false;

        // If this node is already visited via some other source node then avoid checking further again
        if(visited[node])
            return true;

        dfsPath.add(node);
        visited[node] = true;

        for(int adjVertex : graph.get(node)) {
            if(!dfs(adjVertex, graph, visited, dfsPath)) {
                return false;
            }
        }

        dfsPath.remove(node);
        return true;
    }

    public static void main(String[] args) {
        C29_CourseSchedule obj = new C29_CourseSchedule();
        int[][] prerequisites = new int[][]{{1,0}};
        System.out.println(obj.canFinish(2, prerequisites));    //true

        prerequisites = new int[][]{{0,1},{1,0}};
        System.out.println(obj.canFinish(2, prerequisites));    //false

        prerequisites = new int[][]{{0,1},{2,1},{3,2},{3,0}};
        System.out.println(obj.canFinish(4, prerequisites));    //true

        prerequisites = new int[][]{{0,1},{0,2},{2,1},{3,2},{3,0}};
        System.out.println(obj.canFinish(4, prerequisites));   // true

        prerequisites = new int[][]{{0,1},{1,2},{2,0}};
        System.out.println(obj.canFinish(3, prerequisites));   // false

        prerequisites = new int[][]{};
        System.out.println(obj.canFinish(1, prerequisites));   // false

        prerequisites = new int[][]{{1,0}};
        System.out.println(obj.canFinish(3, prerequisites));   // false

    }
}
