import java.util.Arrays;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class ContiguousSubarray {
    public int findMaxLength(int[] nums) {
        int[] countIndices = new int[2*nums.length + 1];
        Arrays.fill(countIndices, -2);
        int maxLength = 0;
        int count = 0;
        countIndices[nums.length] = -1;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? -1 : 1;
            if (countIndices[count + nums.length] >= -1)
                maxLength = Math.max(maxLength, i - countIndices[count + nums.length]);
            else countIndices[count + nums.length] = i;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        ContiguousSubarray contiguousSubarray = new ContiguousSubarray();
        int[] arr = {0, 1};
        System.out.println(contiguousSubarray.findMaxLength(arr));
    }
}