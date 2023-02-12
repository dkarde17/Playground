import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least
 * twice in the array, and return false if every element is distinct.
 * <p>
 * https://leetcode.com/problems/contains-duplicate/description/
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> freq = new HashSet<>();
        for (int num : nums) {
            if (freq.contains(num))
                return true;
            else freq.add(num);
        }
        return false;
    }
}
