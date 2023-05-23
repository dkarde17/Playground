import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping
 * you from robbing each of them is that adjacent houses have security
 * systems connected and it will automatically contact the police if two
 * adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each
 * house, return the maximum amount of money you can rob tonight without
 * alerting the police.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob
 * house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * <p>
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {
    public int rob(int[] nums) {
        Integer[] cache = new Integer[nums.length];
        Arrays.fill(cache, -1);
        return robRecursivelyWithMemoization(nums, nums.length - 1, cache);
    }

    private int robRecursivelyWithMemoization(int[] nums, int i,
                                              Integer[] cache) {
        if (i < 0)
            return 0;
        else if (i == 0)
            return nums[0];
        else if (i == 1)
            return Integer.max(nums[0], nums[1]);
        else {
            if (cache[i] == -1)
                cache[i] = Integer.max(nums[i] + robRecursivelyWithMemoization(nums, i - 2,
                                cache),
                        robRecursivelyWithMemoization(nums, i - 1, cache));
            return cache[i];
        }
    }

    private int bottomsUp(int[] nums) {
        if(nums == null)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Integer.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++)
            dp[i] = Integer.max(nums[i] + dp[i - 2], dp[i - 1]);
        return dp[nums.length - 1];
    }

    private int bottomsUpWithSpaceOptimization(int[] nums) {
        if(nums == null)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int prev2 = nums[0];
        int prev = Integer.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++){
            int pick = nums[i] + prev2;
            int notPick = prev;
            int curr = Integer.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return Integer.max(prev, prev2);
    }
}
