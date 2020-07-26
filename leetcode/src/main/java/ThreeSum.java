import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> targets = new HashSet<>();
        for(int i = 0; i < n - 2; i++) {
            int target = 0 - nums[i];
            Map<Integer, Integer> presentAt = new HashMap<>();
            for(int j = i + 1; j < n; j++) {
                if(presentAt.containsKey(target - nums[j])) {
                    int k = presentAt.get(target - nums[j]);
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[k]);
                    res.add(nums[j]);
                    targets.add(res);
                } else presentAt.put(nums[j], j);
            }
        }

        return new ArrayList<List<Integer>>(targets);
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum.threeSum(arr));
    }
}
