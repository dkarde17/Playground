/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        for(int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for(int j = 1; j < grid[0].length; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for(int i = 1; i < grid.length; i++) {
            for(int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        printGrid(grid);
        return grid[grid.length - 1][grid[0].length - 1];
    }

    private void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.printf("%d, ", grid[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int[][] grid = {{9,1,4,8}};
        System.out.println(minimumPathSum.minPathSum(grid));
    }
}
