public class MaximumSubarray {
    class Solution {

        /**
         * This is Kadane's algorithm implementation
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            int maxSum = Integer.MIN_VALUE;
            int currSum = 0;
            int start = 0;
            int end = 0;
            while(end < nums.length) {
                currSum += nums[end];
                if(currSum > maxSum)
                    maxSum = currSum;
                if(currSum < 0) {
                    currSum = 0;
                    start=end + 1;
                }
                end++;
            }
            return maxSum;
        }
    }
}
