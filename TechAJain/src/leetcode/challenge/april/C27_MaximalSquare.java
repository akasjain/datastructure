package leetcode.challenge.april;

import java.util.Arrays;

/**
 https://leetcode.com/problems/maximal-square/

 Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 Example:
 Input:
 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0

 Output: 4
 */
public class C27_MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];
        int max = 0;

        for(int i = 0; i < row; i++)
            dp[i][0] = matrix[i][0] - '0';
        for(int i = 0; i < col; i++)
            dp[0][i] = matrix[0][i] - '0';

        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(matrix[i][j] == '0') {
                    continue;
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
                if(dp[i][j] > max)
                    max = (int)dp[i][j];
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        C27_MaximalSquare obj = new C27_MaximalSquare();
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        System.out.println(obj.maximalSquare(matrix));
    }
}
