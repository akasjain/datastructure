package ds.graph;

import java.util.*;

class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        // Build graph
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            if(graph.containsKey(u)) {
                Set<Integer> set = graph.get(u);
                set.add(v);
                graph.put(u, set);
            } else {
                graph.put(u, new HashSet<>(Arrays.asList(v)));
            }
            if(!graph.containsKey(v)) {
                graph.put(v, new HashSet<>());
            }
        }

        for (Integer vertex : graph.keySet()) {
            if(visited.contains(vertex))
                continue;
            topSortUtil(graph, visited, stack, vertex);
        }

        while(!stack.empty()) {
            sortedOrder.add(stack.pop());
        }
        return sortedOrder;
    }

    private static void topSortUtil(Map<Integer, Set<Integer>> graph, Set<Integer> visited, Stack<Integer> stack, Integer vertex) {

        visited.add(vertex);    
        for (Integer adjVertex : graph.get(vertex)) {
            if(visited.contains(adjVertex)) {
                continue;
            }
            topSortUtil(graph, visited, stack, adjVertex);
        }
        stack.push(vertex);
    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][] { { 3, 2 }, { 3, 0 }, { 2, 0 }, { 2, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
                new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
                new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);
    }
}
