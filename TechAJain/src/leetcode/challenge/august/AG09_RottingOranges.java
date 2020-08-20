package leetcode.challenge.august;

import java.util.LinkedList;
import java.util.Queue;

/**
 https://leetcode.com/problems/rotting-oranges/

 In a given grid, each cell can have one of three values:

 the value 0 representing an empty cell;
 the value 1 representing a fresh orange;
 the value 2 representing a rotten orange.
 Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

 Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 */
public class AG09_RottingOranges {
    class Point {
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        if(rows == 0)
            return -1;
        int cols = grid[0].length;
        int result = 0;
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};

        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0 ;j < cols; j++) {
                if(grid[i][j] == 2)
                    queue.add(new Point(i, j));
            }
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            for(int i = 0; i < size; i++) {
                Point current = queue.poll();
                for(int j = 0; j < 4; j++) {
                    int newX = current.x + x[j];
                    int newY = current.y + y[j];
                    if(isSafe(grid, newX, newY)) {
                        grid[newX][newY] = 2;
                        queue.add(new Point(newX, newY));
                        flag = true;
                    }
                }
            }
            if(flag)
                result++;
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0 ;j < cols; j++) {
                if(grid[i][j] == 1)
                    return -1;
            }
        }

        return result;
    }

    private boolean isSafe(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1;
    }

    public static void main(String[] args) {
        AG09_RottingOranges obj = new AG09_RottingOranges();

        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(obj.orangesRotting(grid));

        grid = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(obj.orangesRotting(grid));

        grid = new int[][]{{0,2}};
        System.out.println(obj.orangesRotting(grid));

    }
}
