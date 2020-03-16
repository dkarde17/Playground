import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> alreadyPresent = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if(alreadyPresent.containsKey(target-n)) {
                result[0] = alreadyPresent.get(target-n);
                result[1] = i;
                break;
            } else {
                alreadyPresent.put(n, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        twoSum.twoSum(nums, target);
    }
}
