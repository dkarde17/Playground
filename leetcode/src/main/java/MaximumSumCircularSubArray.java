/**
 * 918. Maximum Sum Circular Subarray
 * Medium
 *
 * 551
 *
 * 26
 *
 * Add to List
 *
 * Share
 * Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
 *
 * Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
 *
 * Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
 *
 *
 *
 * Example 1:
 *
 * Input: [1,-2,3,-2]
 * Output: 3
 * Explanation: Subarray [3] has maximum sum 3
 * Example 2:
 *
 * Input: [5,-3,5]
 * Output: 10
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
 * Example 3:
 *
 * Input: [3,-1,2,-1]
 * Output: 4
 * Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
 * Example 4:
 *
 * Input: [3,-2,2,-3]
 * Output: 3
 * Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
 * Example 5:
 *
 * Input: [-2,-3,-1]
 * Output: -1
 * Explanation: Subarray [-1] has maximum sum -1
 *
 *
 * Note:
 *
 * -30000 <= A[i] <= 30000
 * 1 <= A.length <= 30000
 */
public class MaximumSumCircularSubArray {
    //use kadane's algo to get the maximum sum in the non-circular part of the array
    //calculate the prefix sum
    //calculate the suffix sum
    //choose the max of prefix sum and suffix sum and kadane's algo result
    public int maxSubarraySumCircular(int[] A) {
        int res = A[0];
        int currRes = A[0];
        for(int i = 1; i < A.length; i++) {
            currRes += A[i];
            currRes = Math.max(currRes, A[i]);
            res = Math.max(res, currRes);
        }
        int[] maxPrefixSum = new int[A.length];
        maxPrefixSum[0] = A[0];
        int currPrefixSum = A[0];
        int[] maxSuffixSum = new int[A.length];
        maxSuffixSum[A.length - 1] = A[A.length - 1];
        int currSuffixSum = A[A.length - 1];
        for(int i = 1; i < A.length; i++) {
            currPrefixSum += A[i];
            maxPrefixSum[i] = Math.max(currPrefixSum, maxPrefixSum[i - 1]);
            currSuffixSum += A[A.length - i - 1];
            maxSuffixSum[A.length - i - 1] = Math.max(currSuffixSum, maxSuffixSum[A.length - 1]);
        }
        for(int i = 0; i < A.length - 2; i++)
            res = Math.max(res, maxPrefixSum[i] + maxSuffixSum[i + 2]);
        return res;
    }

    public static void main(String[] args) {
        MaximumSumCircularSubArray maximumSumCircularSubArray = new MaximumSumCircularSubArray();
        int[] arr = {-2,4,-5,4,-5,9,4};
        System.out.println(maximumSumCircularSubArray.maxSubarraySumCircular(arr));
    }

    //2ms solution
    /*
    public int maxSubarraySumCircular(int[] array) {
        int acc = 0;
        int max1 = kadane(array);
        for(int i = 0; i < array.length; i++) {
            acc += array[i];
            array[i] = -array[i];
        }
        int min = kadane(array);
        int max2 = acc + min;
        if(max2 == 0) {
            return max1;
        }
        return Math.max(max1, max2);
    }
    public int kadane(int[] array) {
        int maxTillI = array[0];
        int max = array[0];
        for(int i = 1; i < array.length; i++) {
            maxTillI = Math.max(maxTillI+array[i], array[i]);
            max = Math.max(max, maxTillI);
        }
        return max;
    }
     */
}
