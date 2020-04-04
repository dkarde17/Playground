/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int currentNonZero = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                currentNonZero++;
                swap(nums, currentNonZero, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        if(i == j)
            return;
        int c = nums[i];
        nums[i] = nums[j];
        nums[j] = c;
    }
}
