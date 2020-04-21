/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int[] nums = {1};
        int target = 0;
        System.out.println(searchInRotatedSortedArray.search(nums, target));
    }
    public int search(int[] nums, int target) {
        int ans = -1;
        if (nums == null || nums.length == 0)
            return ans;
        int low = 0;
        int high = nums.length - 1;
        int pivot = findPivot(nums, low, high);
        if (pivot == -1)
            return binarySearchModified(nums, low, high, target);
        else if (nums[pivot] == target)
            return pivot;
        else if (target >= nums[0])
            return binarySearchModified(nums, 0, pivot - 1, target);
        else return binarySearchModified(nums, pivot + 1, nums.length - 1, target);
    }

    private int findPivot(int[] nums, int low, int high) {
        if (high < low)
            return -1;
        else if (high == low)
            return low;
        int mid = low + (high - low) / 2;
        if (mid > low && nums[mid] < nums[mid - 1])
            return mid - 1;
        if (mid < high && nums[mid] > nums[mid + 1])
            return mid;
        if (nums[low] >= nums[mid])
            return findPivot(nums, low, mid - 1);
        else return findPivot(nums, mid + 1, high);

    }

    private int binarySearchModified(int[] nums, int low, int high, int target) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                return binarySearchModified(nums, low, mid - 1, target);
            else return binarySearchModified(nums, mid + 1, high, target);
        } else {
            return -1;
        }
    }
}
