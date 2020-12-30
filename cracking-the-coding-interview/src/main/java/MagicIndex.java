/**
 * //CTCI 8.3
 *
 *
 */
public class MagicIndex {
    public int findMagicIndex(int[] nums) {
        int res = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == mid) {
                res = mid;
                break;
            } else if(nums[mid] > mid) {
                right = mid - 1;
            } left = mid + 1;
        }

        return res;
    }

    //if elements are not distinct
    public int findMagicIndexNotDistinct(int[] nums) {
        int n = nums.length;
        return subFind(nums, 0, n);
    }

    private int subFind(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        int result = -1;
        if(nums[mid] == mid) {
            result = mid;
        } else if(nums[mid] < mid) {
            result = subFind(nums, mid + 1, right);
            if (result == -1) {
                result = subFind(nums, left, nums[mid]);
            }
        } else {
            result = subFind(nums, left, mid - 1);
            if (result == 1) {
                result = subFind(nums, nums[mid], right);
            }
        }
        return result;
    }
}
