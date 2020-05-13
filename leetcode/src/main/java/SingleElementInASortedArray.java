/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/
 * <p>
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 * <p>
 * <p>
 * Note: Your solution should run in O(log n) time and O(1) space.
 */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        int res = -1;
        if (nums.length == 1)
            return nums[low];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midNum = nums[mid];
            if(low == high) {
                res = midNum;
                break;
            }
            if (nums[mid - 1] == midNum)
                if ((mid - low + 1) % 2 == 0)
                    low = mid + 1;
                else high = mid;
            else if (nums[mid + 1] == midNum)
                if ((high - mid + 1) % 2 != 0)
                    low = mid;
                else high = mid - 1;
            else {
                res = midNum;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SingleElementInASortedArray singleElementInASortedArray = new SingleElementInASortedArray();
        int[] arr = {1, 1, 2, 2, 3};
        System.out.println(singleElementInASortedArray.singleNonDuplicate(arr));
    }
}
