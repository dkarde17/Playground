import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSums = new int[nums.length];
        prefixSums[0] = nums[0];
        int maxSum = prefixSums[0];
        int minSum = prefixSums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
            if (prefixSums[i] > maxSum)
                maxSum = prefixSums[i];
            if (prefixSums[i] < minSum)
                minSum = prefixSums[i];
        }
        Map<Integer, Integer> hash = new HashMap<>();
        int count = 0;
        for (int sum : prefixSums) {
            if (sum == k) {
                count += 1;
            }
            count += hash.getOrDefault(sum - k, 0);
            hash.computeIfPresent(sum, (x, v) -> ++v);
            hash.putIfAbsent(sum, 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        int[] nums = {-624,-624,-624,-624,-624,-624,-624,-624,-624,-624};
        int k = -624;
        System.out.println(subarraySumEqualsK.subarraySum(nums, k));
    }
}
