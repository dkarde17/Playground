import jdk.vm.ci.meta.SpeculationLog;

/**
 * https://leetcode.com/problems/subarray-product-less-than-k/
 *
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of
 * all the elements in the subarray is strictly less than k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0, currProduct = 1, l = 0, r = 0, n = nums.length, counter = 0;
        while(r < n) {
            if ( currProduct * nums[r] < k ){//check the current right number before accepting
                currProduct *= nums[r++];
                ans += ++counter;
            } else {
                if (r == l) {
                    r++; l++;
                }
                else while(l < r && currProduct * nums[r] >= k) { //make the current right number more acceptable and
                    // then accept it in the next round
                    currProduct /= nums[l++];
                    counter--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK object = new SubarrayProductLessThanK();
        int[] nums = {1, 2, 3};
        int k = 0;
        System.out.println(object.numSubarrayProductLessThanK(nums, k));
    }
}
