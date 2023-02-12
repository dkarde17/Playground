import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(hash.containsKey(diff)) {
                res[0] = i;
                res[1] = hash.get(diff);
                break;
            } else hash.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        twoSum.twoSum(nums, target);
    }
}
