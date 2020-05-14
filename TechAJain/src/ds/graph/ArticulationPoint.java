package ds.graph;

import java.lang.reflect.Array;
import java.util.*;

public class ArticulationPoint {

    private int time;

    public List<List<Integer>> criticalConnections(List<List<Integer>> connections) {

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (List<Integer> edge : connections) {
            int num1 = edge.get(0);
            int num2 = edge.get(1);

            if(graph.containsKey(num1)) {
                Set<Integer> set = graph.get(num1);
                set.add(num2);
                graph.put(num1, set);
            } else {
                graph.put(num1, new HashSet<>(Arrays.asList(num2)));
            }

            if(graph.containsKey(num2)) {
                Set<Integer> set = graph.get(num2);
                set.add(num1);
                graph.put(num2, set);
            } else {
                graph.put(num2, new HashSet<>(new HashSet<>(Arrays.asList(num1))));
            }
        }

        time = 0;
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> articulationPoints = new ArrayList<>();
        Map<Integer, Integer> visitedTime = new HashMap<>();
        Map<Integer, Integer> lowTime = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Integer startVertex = graph.keySet().iterator().next(); // any random vertex at start
        Map<Integer, Boolean> articulationVertex = new HashMap<>();
        DFS(graph, articulationVertex, visited, visitedTime, lowTime, parent, startVertex);

        // make vertex into points
        System.out.println(articulationVertex.toString());

        for (Integer vertex: articulationVertex.keySet()) {
            if(articulationVertex.get(vertex)) {
                for (Integer adj: graph.get(vertex)) {
                    if(visitedTime.get(vertex) < lowTime.get(adj)) {
                        articulationPoints.add(Arrays.asList(vertex, adj));
                    }
                }
            }
        }

        return articulationPoints;
    }

    private void DFS(Map<Integer, Set<Integer>> graph,
                     Map<Integer, Boolean> articulationVertex,
                     Set<Integer> visited,
                     Map<Integer, Integer> visitedTime,
                     Map<Integer, Integer> lowTime,
                     Map<Integer, Integer> parent,
                     Integer currentVertex) {

        visited.add(currentVertex);
        visitedTime.put(currentVertex, time);
        lowTime.put(currentVertex, time);
        time++;

        int childCount = 0;
        articulationVertex.put(currentVertex, false);

        for(Integer adjVertex: graph.get(currentVertex)) {

            if(parent.get(currentVertex) == adjVertex)
                continue;

            // Visit the not visited adjacent vertex
            if(!visited.contains(adjVertex))  {
                parent.put(adjVertex, currentVertex);
                childCount++;
                DFS(graph, articulationVertex, visited, visitedTime, lowTime, parent, adjVertex);

                if(visitedTime.get(currentVertex) <= lowTime.get(adjVertex)) { // indicates a back edge
                    articulationVertex.put(currentVertex, true);
                } else {
                    // update lowTime with current adjacent vertex
                    lowTime.compute(currentVertex,
                            (key, time) -> Math.min(time, lowTime.get(adjVertex))
                    );
                }
            } else {
                lowTime.compute(currentVertex,
                        (key, time) -> Math.min(time, lowTime.get(adjVertex))
                );
            }
        }

        if((parent.get(currentVertex) == null && childCount >= 2) ||
                (parent.get(currentVertex) != null && articulationVertex.get(currentVertex))) {
            articulationVertex.put(currentVertex, true);
        } else {
            articulationVertex.put(currentVertex, false);
        }
    }

    public static void main(String[] args) {

        /*List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));*/

        //Input: n = 5, edges = [[1, 2], [1, 3], [3, 4], [1, 4], [4, 5]]
        /*List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(1,3));
        connections.add(Arrays.asList(3,4));
        connections.add(Arrays.asList(1,4));
        connections.add(Arrays.asList(4,5));*/

        //Input: n = 6, edges = [[1, 2], [1, 3], [2, 3], [2, 4], [2, 5], [4, 6], [5, 6]]
        /*List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(1,3));
        connections.add(Arrays.asList(2,3));
        connections.add(Arrays.asList(2,4));
        connections.add(Arrays.asList(2,5));
        connections.add(Arrays.asList(4,6));
        connections.add(Arrays.asList(5,6));*/

        //Input: n = 9, edges = [[1, 2], [1, 3], [2, 3], [3, 4], [3, 6], [4, 5], [6, 7], [6, 9], [7, 8], [8, 9]]
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(1,3));
        connections.add(Arrays.asList(2,3));
        connections.add(Arrays.asList(3,4));
        connections.add(Arrays.asList(3,6));
        connections.add(Arrays.asList(4,5));
        connections.add(Arrays.asList(6,7));
        connections.add(Arrays.asList(6,9));
        connections.add(Arrays.asList(7,8));
        connections.add(Arrays.asList(8,9));

        ArticulationPoint ap = new ArticulationPoint();
        List<List<Integer>> articulationPoints = ap.criticalConnections(connections);
        System.out.println(articulationPoints.toString());
    }
}
