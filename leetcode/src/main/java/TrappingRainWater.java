/**
 *
 * leetcode 42 - https://leetcode.com/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-interview-150
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
 * water it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this
 * case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int currLeftMax = height[0];
        for(int i = 1; i < leftMax.length; i++) {
            leftMax[i] = currLeftMax;
            currLeftMax = Math.max(currLeftMax, height[i]);
        }
        int currRightMax = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = currRightMax;
            currRightMax = Math.max(currRightMax, height[i]);
        }
        int total = 0;
        for(int i = 0; i < height.length - 1; i++) {
            total += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return total;
    }
}
