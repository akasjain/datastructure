package leetcode.challenge.april;

import java.util.Arrays;

/**
 https://leetcode.com/problems/minimum-path-sum/

 Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.

 Example:
 Input: [
     [1,3,1],
     [1,5,1],
     [4,2,1]]
 Output: 7
 Explanation: Because the path 1→3→1→1→1 minimizes the sum.

 */
public class C18_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0)
            return 0;

        int row = grid.length;
        int col = grid[0].length;

        int[][] output = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(output[i], -1);
        }


        return minPathSumRec(grid, row-1, col-1, 0, 0, output);
    }

    public int minPathSumRec(int[][] grid, int row, int col, int x, int y, int[][] output) {

        if(x < 0 || x > row || y < 0 || y > col)
            return Integer.MAX_VALUE;

        if(output[x][y] != -1)
            return output[x][y];

        if(x == row) {
            int currentCol = y;
            int currentSum = 0;
            while(currentCol <= col) {
                currentSum += grid[x][currentCol];
                currentCol++;
            }
            output[x][y] = currentSum;
            return currentSum;
        }

        if(y == col) {
            int currentRow = x;
            int currentSum = 0;
            while(currentRow <= row) {
                currentSum += grid[currentRow][y];
                currentRow++;
            }
            output[x][y] = currentSum;
            return currentSum;
        }
        int down;
        int right;
        if(output[x+1][y] == -1) {
            down = minPathSumRec(grid, row, col, x+1, y, output);
        } else {
            down = output[x+1][y];
        }
        if(output[x][y+1] == -1) {
            right = minPathSumRec(grid, row, col, x, y+1, output);
        } else {
            right = output[x][y+1];
        }
        output[x][y] = grid[x][y] + Math.min(down, right);

        return output[x][y];
    }

    public static void main(String[] args) {
        C18_MinimumPathSum obj = new C18_MinimumPathSum();

        long startTime = System.currentTimeMillis();
        int result = obj.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        System.out.println(result);

        startTime = System.currentTimeMillis();
        result = obj.minPathSum(new int[][]{{3,8,6,0,5,9,9,6,3,4,0,5,7,3,9,3},{0,9,2,5,5,4,9,1,4,6,9,5,6,7,3,2},{8,2,2,3,3,3,1,6,9,1,1,6,6,2,1,9},{1,3,6,9,9,5,0,3,4,9,1,0,9,6,2,7},{8,6,2,2,1,3,0,0,7,2,7,5,4,8,4,8},{4,1,9,5,8,9,9,2,0,2,5,1,8,7,0,9},{6,2,1,7,8,1,8,5,5,7,0,2,5,7,2,1},{8,1,7,6,2,8,1,2,2,6,4,0,5,4,1,3},{9,2,1,7,6,1,4,3,8,6,5,5,3,9,7,3},{0,6,0,2,4,3,7,6,1,3,8,6,9,0,0,8},{4,3,7,2,4,3,6,4,0,3,9,5,3,6,9,3},{2,1,8,8,4,5,6,5,8,7,3,7,7,5,8,3},{0,7,6,6,1,2,0,3,5,0,8,0,8,7,4,3},{0,4,3,4,9,0,1,9,7,7,8,6,4,6,9,5},{6,5,1,9,9,2,2,7,4,2,7,2,2,3,7,2},{7,1,9,6,1,2,7,0,9,6,6,4,4,5,1,0},{3,4,9,2,8,3,1,2,6,9,7,0,2,4,2,0},{5,1,8,8,4,6,8,5,2,4,1,6,2,2,9,7}});
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        System.out.println(result);

    }
}
