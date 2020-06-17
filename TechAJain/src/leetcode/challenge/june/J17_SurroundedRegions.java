package leetcode.challenge.june;

import java.util.Arrays;

/**
 https://leetcode.com/problems/surrounded-regions/

 Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 Example:
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 */
public class J17_SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length;
        if(m <= 2)
            return;

        int n = board[0].length;
        if(n <= 2)
            return;

        boolean[][] visited = new boolean[m][n];

        for(int j = 0; j < n; j++) { // first and last row
            if(board[0][j] == 'O' && !visited[0][j]) {
                dfs(board, visited, 0, j);
            }
            if(board[m - 1][j] == 'O' && !visited[m - 1][j]) {
                dfs(board, visited, m - 1, j);
            }
        }

        for(int i = 1; i < m - 1; i++) { // first and last column
            if(board[i][n - 1] == 'O' && !visited[i][n - 1]) {
                dfs(board, visited, i, n - 1);
            }
            if(board[i][0] == 'O' && !visited[i][0]) {
                dfs(board, visited, i, 0);
            }
        }

        for(int i = 1; i < m - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                if(board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] ||
                board[i][j] == 'X') {
            return;
        }
        visited[i][j] = true;
        dfs(board, visited, i - 1, j);
        dfs(board, visited, i, j + 1);
        dfs(board, visited, i + 1, j);
        dfs(board, visited, i, j - 1);
    }

    public static void main(String[] args) {
        J17_SurroundedRegions obj = new J17_SurroundedRegions();
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        obj.solve(board);
        Arrays.stream(board).forEach(row -> System.out.println(Arrays.toString(row)));

        board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','X','O','X'}};
        obj.solve(board);
        Arrays.stream(board).forEach(row -> System.out.println(Arrays.toString(row)));
    }
}