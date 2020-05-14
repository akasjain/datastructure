package leetcode.challenge.april;

/*
 https://leetcode.com/problems/number-of-islands/

 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 You may assume all four edges of the grid are all surrounded by water.
*/
public class C17_NumberOfIslands {
    public int numIslands(char[][] grid) {

        if(grid.length == 0)
            return 0;

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    count ++;
                    numIslandsRec(grid, visited, row, col, i, j);
                }
            }
        }

        return count;
    }

    public void numIslandsRec(char[][] grid, boolean[][] visited, int row, int col, int i, int j) {
        if(i < 0 || i >= row || j < 0 || j >= col)
            return;
        if(!visited[i][j]) {
            visited[i][j] = true;
            if(grid[i][j] == '0')
                return;

            numIslandsRec(grid, visited, row, col, i-1, j);
            numIslandsRec(grid, visited, row, col, i+1, j);
            numIslandsRec(grid, visited, row, col, i, j-1);
            numIslandsRec(grid, visited, row, col, i, j+1);


        }
    }

    public static void main(String[] args) {
        C17_NumberOfIslands obj = new C17_NumberOfIslands();


        final char[][] grid = {
                {'1','1','0','0','0'},
                {'0','1','0','0','1'},
                {'1','0','0','1','1'},
                {'0','0','0','0','0'},
                {'1','0','1','0','1'}
        };

        int result = obj.numIslands(grid);
        System.out.println(result);
    }
}
