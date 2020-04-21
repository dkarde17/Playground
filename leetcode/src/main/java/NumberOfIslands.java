/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int islands = 0;
        if(grid.length == 0)
            return islands;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if('1' == grid[i][j] && !visited[i][j]) {
                    discoverConnected(grid, i, j, visited);
                    ++islands;
                }
            }
        }
        return islands;
    }

    private void discoverConnected(char[][] grid, int x, int y, boolean[][] visited) {
        int[] xOffsets = {-1, 0, 0, 1};
        int[] yOffsets = {0, -1, 1, 0};
        int rows = grid.length;
        int cols = grid[0].length;
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int xIndex = x + xOffsets[i];
            int yIndex = y + yOffsets[i];
            if(xIndex >= 0 && xIndex < rows && yIndex >= 0 && yIndex < cols
                    && '1' == grid[xIndex][yIndex] && !visited[xIndex][yIndex]) {
                discoverConnected(grid, xIndex, yIndex, visited);
            }
        }
    }
}
