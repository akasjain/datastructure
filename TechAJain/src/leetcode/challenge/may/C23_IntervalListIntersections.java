package leetcode.challenge.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 https://leetcode.com/problems/interval-list-intersections/

 Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 Return the intersection of these two interval lists.

 Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

 Note:
 0 <= A.length < 1000
 0 <= B.length < 1000
 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 */
public class C23_IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A.length == 0 || B.length == 0)
            return new int[0][0];

        int index1 = 0;
        int index2 = 0;
        List<int[]> result = new ArrayList<>();

        while(index1 < A.length && index2 < B.length) {

            int start = Math.max(A[index1][0], B[index2][0]);
            int end = Math.min(A[index1][1], B[index2][1]);

            if(start <= end) {
                result.add(new int[]{start, end});
            }

            if(A[index1][1] < B[index2][1]) {
                index1++;
            } else {
                index2++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] B = new int[][]{{1,5},{8,12},{15,24},{25,26}};
        C23_IntervalListIntersections obj = new C23_IntervalListIntersections();

        int[][] result = obj.intervalIntersection(A, B);
        for(int[] interval: result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
