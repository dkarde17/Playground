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

    /**
     * Sliding window is more easily observable in this way
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int zeroCount = 0;
        int lastZeroIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if( nums[i] != 0 && zeroCount > 0) {
                nums[lastZeroIndex++] = nums[i];
                nums[i] = 0; //lazy swap, just making it 0
                zeroCount--;
            }
            if( nums[i] == 0 ) {
                if(zeroCount == 0)
                    lastZeroIndex = i;
                zeroCount++;
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
