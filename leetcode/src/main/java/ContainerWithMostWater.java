/**
 * leetcode 11 - https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
 * the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of
 * water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int water = Integer.MIN_VALUE;
        while(left < right) {
            int min = Math.min(height[left], height[right]);
            int area = (right - left) * min;
            if(area > water)
                water = area;
            while(left < right && height[left] <= min)
                left++;
            while(left < right && height[right] <= min)
                right--;
        }
        return water;
    }
}
