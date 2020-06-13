package leetcode.challenge.may;

import java.util.Arrays;
import java.util.PriorityQueue;

public class C30_KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {

        if(points.length == 0)
            return points;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) ->
                distance(points[i2][0], points[i2][1]) - distance(points[i1][0], points[i1][1]));

        for(int i = 0; i < points.length; i++) {
            maxHeap.add(i);
            if(maxHeap.size() > K) {
                maxHeap.poll();
            }
        }
        int index = 0;
        int[][] result = new int[maxHeap.size()][2];

        while(!maxHeap.isEmpty()) {
            int top = maxHeap.poll();
            result[index][0] = points[top][0];
            result[index++][1] = points[top][1];
        }

        return result;
    }

    private int distance(int x, int y) {
        return x*x + y*y;
    }

    public static void main(String[] args) {
        C30_KClosestPointsToOrigin obj = new C30_KClosestPointsToOrigin();
        int[][] points = new int[][]{{-5,4},{-6,-5},{4,6}};
        int[][] result = obj.kClosest(points, 2);
        for(int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }
}
