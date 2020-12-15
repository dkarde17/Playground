/**
 * https://leetcode.com/problems/unique-paths-ii
 * CTCI 8.2
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 *
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class UniquePathsII {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths II.
     * Memory Usage: 38.2 MB, less than 13.30% of Java online submissions for Unique Paths II.
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0)
            return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < m && obstacleGrid[0][i] != 1; i++)
                dp[0][i] = 1;
        for(int i = 0; i < n && obstacleGrid[i][0] != 1; i++)
                dp[i][0] = 1;

        for(int i = 1; i < n; i++)
            for(int j = 1; j < m; j++)
                if(obstacleGrid[i][j] != 1)
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        UniquePathsII uniquePathsII = new UniquePathsII();
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsII.uniquePathsWithObstacles(grid));
    }
}
