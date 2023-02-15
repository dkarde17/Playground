/**
 * Given an integer array nums, rotate the array to the right by k steps,
 * where k is non-negative.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 *
 * Follow up:
 *
 * Try to come up with as many solutions as you can. There are at least three
 * different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 *
 * https://leetcode.com/problems/rotate-array/description/
 */
public class RorateArray {
    /**
     * 1 shuffle = 1 whole reverse + 2 individual part reverses
     * for e.g.
     * rotate +++>==> 3 times to the right, final answer will look like ==>+++>
     * this is like the last 3 characters were shuffled to the front
     * so, we can also solve it with 3 reverses:
     * reverse whole <==<+++
     * reverse 1st part ==><+++
     * reverse 2nd part ==>+++>
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        int left = 0;
        int right = nums.length - 1;
        reverse(nums, left, right);
        reverse(nums, left, k - 1);
        reverse(nums, k, right);
    }

    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
            swap(nums, left++, right--);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    /**
     * starting with 1 index we cycle through the array moving each element
     * to its respective future index after k rotations i.e. (i + k)%n
     *But it may result in reaching the same index again and getting stuck in
     *  a cycle.
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k%=n;
        int totalLoops = gcd(n, k);
        while(totalLoops > 0) {
            //cycle through the array
            int i = totalLoops - 1;
            int next = (i + k)%n;
            int last = nums[i];
            while (i != next) {
                int temp = nums[next];
                nums[next] = last;
                last = temp;
                next = (next + k) % n;
            }
            nums[next] = last;
            totalLoops--;
        }
    }

    private int gcd(int x, int y) {
        return y == 0? x : gcd(y, x%y);
    }
}
