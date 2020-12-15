/**
 * https://leetcode.com/problems/unique-paths/
 *
 * CTCI 8.2 (similar)
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 *
 * Example 1:
 *
 *
 * Input: m = 3, n = 7
 * Output: 28
 * Example 2:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 * Example 3:
 *
 * Input: m = 7, n = 3
 * Output: 28
 * Example 4:
 *
 * Input: m = 3, n = 3
 * Output: 6
 *
 *
 * Constraints:
 *
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 109.
 */
public class UniquePaths {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
     * Memory Usage: 35.6 MB, less than 98.16% of Java online submissions for Unique Paths.
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0)
            return 0;
        if(m == 1 || n == 1)
            return 1;
        int[][] arr = new int[m][n];
        for(int i = 0; i < n; i++)
            arr[0][i] = 1;
        for(int i = 0; i < m; i++)
            arr[i][0] = 1;
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                arr[i][j] = arr[i-1][j] + arr[i][j - 1];
        return arr[m - 1][n - 1];
    }
}
