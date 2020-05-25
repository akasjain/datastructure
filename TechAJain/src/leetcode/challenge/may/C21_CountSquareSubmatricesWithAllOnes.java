package leetcode.challenge.may;

/**
 https://leetcode.com/problems/count-square-submatrices-with-all-ones/

 Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 Example 1:
    Input: matrix =
     [
     [0,1,1,1],
     [1,1,1,1],
     [0,1,1,1]
     ]
     Output: 15
 Explanation:
    There are 10 squares of side 1.
    There are 4 squares of side 2.
    There is  1 square of side 3.
    Total number of squares = 10 + 4 + 1 = 15.

 Constraints:
    1. 1 <= arr.length <= 300
    2. 1 <= arr[0].length <= 300
    3. 0 <= arr[i][j] <= 1
 */
public class C21_CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m][n];
        int result = 0;

        for(int i = 0; i < n; i++) {
            sum[0][i] = matrix[0][i];
            result += matrix[0][i];
        }
        for(int i = 1; i < m; i++) {
            sum[i][0] = matrix[i][0];
            result += matrix[i][0];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    sum[i][j] = 0;
                    continue;
                }
                if(matrix[i-1][j-1] != 0 && matrix[i][j-1] != 0 && matrix[i-1][j] != 0) {
                    int min = Math.min(sum[i-1][j-1], Math.min(sum[i][j-1], sum[i-1][j]));
                    sum[i][j] = 1 + min;
                } else {
                    sum[i][j] = matrix[i][j];
                }
                result += sum[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        C21_CountSquareSubmatricesWithAllOnes obj = new C21_CountSquareSubmatricesWithAllOnes();
        System.out.println(obj.countSquares(matrix));

        matrix = new int[][]{{1,0,1},{1,1,0},{1,1,0}};
        System.out.println(obj.countSquares(matrix));

        matrix = new int[][]{{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(obj.countSquares(matrix));

        matrix = new int[][]{{1,1},{1,1}};
        System.out.println(obj.countSquares(matrix));
    }
}
