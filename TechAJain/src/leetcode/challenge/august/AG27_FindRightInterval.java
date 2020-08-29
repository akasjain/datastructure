package leetcode.challenge.august;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class AG27_FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length < 1) {
            return new int[0];
        }
        int len = intervals.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            map.put(intervals[i][0], i);
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < len; ++i) {
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (intervals[m][0] < intervals[i][1]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            if (l < len && intervals[l][0] >= intervals[i][1]) {
                result[map.get(intervals[i][0])] = map.get(intervals[l][0]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AG27_FindRightInterval obj = new AG27_FindRightInterval();
        int[] result = obj.findRightInterval(new int[][]{{1,12},{2,9},{3,10},{13,14},{15,16},{16,17}});
        System.out.println(Arrays.toString(result));

        result = obj.findRightInterval(new int[][]{{4,5},{2,3},{1,2}});
        System.out.println(Arrays.toString(result));
    }
}
