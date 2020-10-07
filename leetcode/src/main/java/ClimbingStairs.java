/**
 * https://leetcode.com/problems/climbing-stairs/
 *
 * CTCI 8.1
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        return climbStairs(n, new int[n + 1]);

        /*
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
        Memory Usage: 35.4 MB, less than 99.15% of Java online submissions for Climbing Stairs.

        int[] arr = new int[n + 1];
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
         */
    }



    /**
     * memoization
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
     * Memory Usage: 35.3 MB, less than 99.89% of Java online submissions for Climbing Stairs.
     * @param n
     * @param arr
     * @return
     */
    public int climbStairs(int n, int[] arr) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        if(arr[n] == 0)
            arr[n] = climbStairs(n - 1, arr) + climbStairs(n - 2, arr);
        return arr[n];
    }
}

