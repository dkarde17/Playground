import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 *
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */
public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        Map<Integer, int[]> tracker = new HashMap<>();
        int degree = 0;
        int res = nums.length;
        for(int i = 0; i < nums.length; i++) {
            AtomicInteger ai = new AtomicInteger(i);
            int num = nums[i];
            tracker.computeIfPresent(num, (k, v) -> {
                v[1] = ai.get();
                ++v[2];
                return v;
            });
            tracker.computeIfAbsent(num, k -> {
                int[] array = new int[3];
                array[0] = ai.get();
                array[1] = ai.get();
                array[2] = 1;
                return array;
            });
            int[] ar = tracker.get(num);
            if(ar[2] > degree) {
                degree = ar[2];
                res = ar[1] - ar[0] + 1;
            }else if (ar[2] == degree)
                res = Math.min(res, ar[1] - ar[0] + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        DegreeOfAnArray degreeOfAnArray = new DegreeOfAnArray();
        int[] array = {1,2,2,3,1};
        System.out.println(degreeOfAnArray.findShortestSubArray(array));

    }

    /*
    //top most answer, and tbh i was thinking along the same lines in the beginning
     public int findShortestSubArray(int[] nums) {
          int max = 0;
        for (int num : nums) if (num > max) max = num;
        int[] count = new int[max + 1], pos = new int[max + 1];
        int degree = 1, res = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            count[num]++;
            if (count[num] == 1) pos[num] = i;
            if (count[num] > degree) {
                degree = count[num];
                res = i - pos[num] + 1;
            } else if (count[num] == degree) res = Math.min(res, i - pos[num] + 1);
        }
        return res;
    }
     */
}
