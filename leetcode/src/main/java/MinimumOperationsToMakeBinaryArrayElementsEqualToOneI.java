/**
 * You are given a
 * binary array
 *  nums.
 *
 * You can do the following operation on the array any number of times (possibly zero):
 *
 * Choose any 3 consecutive elements from the array and flip all of them.
 * Flipping an element means changing its value from 0 to 1, and from 1 to 0.
 *
 * Return the minimum number of operations required to make all elements in nums equal to 1. If it is impossible,
 * return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,1,1,0,0]
 *
 * Output: 3
 *
 * Explanation:
 * We can do the following operations:
 *
 * Choose the elements at indices 0, 1 and 2. The resulting array is nums = [1,0,0,1,0,0].
 * Choose the elements at indices 1, 2 and 3. The resulting array is nums = [1,1,1,0,0,0].
 * Choose the elements at indices 3, 4 and 5. The resulting array is nums = [1,1,1,1,1,1].
 * Example 2:
 *
 * Input: nums = [0,1,1,1]
 *
 * Output: -1
 *
 * Explanation:
 * It is impossible to make all elements equal to 1.
 *
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 105
 * 0 <= nums[i] <= 1
 *
 * 3191 - https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/
 */
public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {
    public int minOperations(int[] nums) {
        int ans = 0;
        int i = 0;
        while(i < nums.length - 2) {
            if(nums[i] + nums[i + 1] + nums[i + 2] == 0){
                ans++;
                i += 3;
            } else if (nums[i] + nums[i + 1] + nums[i + 2] == 3) {
                i += 2;
            } else if (nums[i] == 0) {
                nums[i] = 1;
                ans++;
                if(nums[i + 1] == 0)
                    nums[i + 1] = 1;
                else nums[i + 1] = 0;
                if(nums[i + 2] == 0)
                    nums[i + 2] = 1;
                else nums[i + 2] = 0;
                i++;
            } else i++;
        }
        if(i >= nums.length)
            return ans;
        else {
            boolean temp = true;
            temp = temp && nums[i] == 1;
            if(i + 1 < nums.length)
                temp = temp && nums[i + 1] == 1;
            return temp ? ans : -1;
        }
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeBinaryArrayElementsEqualToOneI obj =
                new MinimumOperationsToMakeBinaryArrayElementsEqualToOneI();
        int[] arr = {0, 1, 1, 1, 0, 0};
        int[][] a = {{2,2}, {1, 1}, {0, 0}};
        System.out.println(obj.minOperations(arr));
    }
}
