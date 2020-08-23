package leetcode.challenge.august;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

public class AG22_RandomPointInNonoverlappingRectangles {
    private int[][] rects;
    private Random r;
    private TreeMap<Integer, Integer> map;
    private int area;

    public AG22_RandomPointInNonoverlappingRectangles(int[][] rects) {
        this.rects = rects;
        r = new Random();
        map = new TreeMap<>();
        area = 0;
        for (int i = 0; i < rects.length; i++) {
            area += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            map.put(area, i);
        }
        map.forEach((k, v) -> System.out.println("Key - " + k + " Value - " + v));

    }

    public int[] pick() {
        int randInt = r.nextInt(area);
        int key = map.higherKey(randInt);
        int[] rect = rects[map.get(key)];
        int x = rect[0] + (key - randInt - 1) % (rect[2] - rect[0] + 1);
        int y = rect[1] + (key - randInt - 1) / (rect[2] - rect[0] + 1);
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        AG22_RandomPointInNonoverlappingRectangles obj = new AG22_RandomPointInNonoverlappingRectangles(new int[][]{{1,1,5,5}});
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));

        System.out.println();
        AG22_RandomPointInNonoverlappingRectangles obj2 = new AG22_RandomPointInNonoverlappingRectangles(new int[][]{{-2,-2,-1,-1},{1,0,3,0}});
        System.out.println(Arrays.toString(obj2.pick()));
        System.out.println(Arrays.toString(obj2.pick()));
        System.out.println(Arrays.toString(obj2.pick()));
        System.out.println(Arrays.toString(obj2.pick()));
        System.out.println(Arrays.toString(obj2.pick()));
        System.out.println(Arrays.toString(obj2.pick()));


        AG22_RandomPointInNonoverlappingRectangles obj3 = new AG22_RandomPointInNonoverlappingRectangles(new int[][]{{82918473, -57180867, 82918476, -57180863}, {83793579, 18088559, 83793580, 18088560}, {66574245, 26243152, 66574246, 26243153}, {72983930, 11921716, 72983934, 11921720}});
        System.out.println(Arrays.toString(obj3.pick()));
        System.out.println(Arrays.toString(obj3.pick()));
        System.out.println(Arrays.toString(obj3.pick()));
        System.out.println(Arrays.toString(obj3.pick()));
        System.out.println(Arrays.toString(obj3.pick()));

    }
}
