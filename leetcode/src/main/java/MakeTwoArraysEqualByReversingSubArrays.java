/**
 * https://leetcode.com/contest/biweekly-contest-27/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 * <p>
 * Given two integer arrays of equal length target and arr.
 * <p>
 * In one step, you can select any non-empty sub-array of arr and reverse it. You are allowed to make any number of steps.
 * <p>
 * Return True if you can make arr equal to target, or False otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = [1,2,3,4], arr = [2,4,1,3]
 * Output: true
 * Explanation: You can follow the next steps to convert arr to target:
 * 1- Reverse sub-array [2,4,1], arr becomes [1,4,2,3]
 * 2- Reverse sub-array [4,2], arr becomes [1,2,4,3]
 * 3- Reverse sub-array [4,3], arr becomes [1,2,3,4]
 * There are multiple ways to convert arr to target, this is not the only way to do so.
 * Example 2:
 * <p>
 * Input: target = [7], arr = [7]
 * Output: true
 * Explanation: arr is equal to target without any reverses.
 * Example 3:
 * <p>
 * Input: target = [1,12], arr = [12,1]
 * Output: true
 * Example 4:
 * <p>
 * Input: target = [3,7,9], arr = [3,7,11]
 * Output: false
 * Explanation: arr doesn't have value 9 and it can never be converted to target.
 * Example 5:
 * <p>
 * Input: target = [1,1,1,1,1], arr = [1,1,1,1,1]
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * target.length == arr.length
 * 1 <= target.length <= 1000
 * 1 <= target[i] <= 1000
 * 1 <= arr[i] <= 1000
 */
public class MakeTwoArraysEqualByReversingSubArrays {

    public boolean canBeEqual(int[] target, int[] arr) {
        int i = 0;
        boolean res = false;
        while (i < target.length) {
            if (target[i] != arr[i]) {
                int j = search(arr, target[i], i);
                if (j == -1)
                    break;
                reverse(arr, i, j);
            } else if (i == target.length - 1)
                res = true;
            i++;
        }
        return res;
    }

    private void reverse(int[] arr, int i, int j) {
        while (i < j)
            swap(arr, i++, j--);
    }

    private void swap(int[] arr, int i, int j) {
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    private int search(int[] arr, int target, int k) {
        int res = -1;
        for (int i = k + 1; i < arr.length; i++)
            if (arr[i] == target) {
                res = i;
                break;
            }
        return res;
    }

    /*
    since the problem allows any number of reversals, that means that
    if all the elements are present in the array, we can make it equal to target
    with small pair-wise reversals (like in bubble sort)
    So, all we need to do is check if all the elements are present in the given array or not
     */
    public boolean canBeEqual2(int[] target, int[] arr) {
        int[] targetHash = new int[1001];
        for (int val : target)
            ++targetHash[val];
        for (int val : arr)
            if (--targetHash[val] < 0)
                return false;
        return true;
    }

    //most brilliant equality check ever!!
    public boolean canBeEqual3(int[] target, int[] arr) {

        int x = 0;
        for(int i=0;i<target.length;i++)
        {
            x = x ^ target[i] ^ arr[i];
        }
        return x == 0;

    }


    public static void main(String[] args) {
        MakeTwoArraysEqualByReversingSubArrays makeTwoArraysEqualByReversingSubArrays = new MakeTwoArraysEqualByReversingSubArrays();
        int[] target = {630, 262, 255, 927, 255, 924, 310, 872, 492, 750, 376, 651, 312, 445, 238, 330, 149, 604, 714, 48, 852, 444};
        int[] arr = {444, 927, 48, 924, 262, 376, 852, 238, 872, 630, 310, 492, 149, 255, 651, 255, 750, 604, 445, 330, 312, 714};
        System.out.println(makeTwoArraysEqualByReversingSubArrays.canBeEqual(target, arr));
    }
}
