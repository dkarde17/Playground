public class MaximumSubarray {
    class Solution {

        /**
         * This is Kadane's algorithm implementation
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            int max_overall = nums[0], current_max = nums[0];
            int start = 0, end = 0;
            for(int i = 1; i < nums.length; i++) {
                current_max = current_max + nums[i];
                if (current_max < nums[i]) {
                    current_max = nums[i];
                    start = i;
                }
                if (max_overall < current_max) {
                    max_overall = current_max;
                    end = i;
                }
            }
            return max_overall;
        }
    }
}
