package leetcode.challenge.april;

/**
 https://leetcode.com/problems/leftmost-column-with-at-least-a-one/

 A binary matrix means that all elements are 0 or 1.
 For each individual row of the matrix, this row is sorted in non-decreasing order.
 Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.

 You can’t access the Binary Matrix directly. You may only access the matrix using a BinaryMatrix interface:
 BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
 BinaryMatrix.dimensions() returns a list of 2 elements [m, n], which means the matrix is m * n.

 Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.
 For custom testing purposes you’re given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.

 Example 1:
    Input: mat = [[0,0],[1,1]]
    Output: 0

 Example 2:
    Input: mat = [[0,0],[0,1]]
    Output: 1

 Example 3:
    Input: mat = [[0,0],[0,0]]
    Output: -1

 Example 4:
    Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
    Output: 1
 */
public class C21_LeftmostColumnWithAtLeastAOne {

    public static class BinaryMatrix {
        int[][] binaryMatrix;

        public BinaryMatrix(int[][] matrix) {
            this.binaryMatrix = matrix;
        }

        public int get(int x, int y) {
            return binaryMatrix[x][y];
        }

        public int[] dimensions() {
            return new int[]{binaryMatrix.length, binaryMatrix[0].length};
        }
    }

    public int findLeftmostIndexOfOne(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int candidate = -1;
        for (int r = 0, c = cols - 1; r < rows && c >= 0; ) {
            if (matrix[r][c] == 1) {
                candidate = c;
                c--;
            } else {
                r++;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        C21_LeftmostColumnWithAtLeastAOne obj = new C21_LeftmostColumnWithAtLeastAOne();

        int[][] matrix = {
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 1},
                {0, 0, 0, 0}};
        System.out.println(obj.findLeftmostIndexOfOne(matrix)); // Answer 1

        int[][] matrix2 = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        System.out.println(obj.findLeftmostIndexOfOne(matrix2)); // Answer -1

        int[][] matrix3 = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1}};
        System.out.println(obj.findLeftmostIndexOfOne(matrix3)); // Answer 3
    }
}
