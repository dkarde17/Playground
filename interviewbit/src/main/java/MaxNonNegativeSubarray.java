import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.interviewbit.com/problems/max-non-negative-subarray/
 * <p>
 * Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
 * <p>
 * The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 * <p>
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
 * <p>
 * Find and return the required subarray.
 * <p>
 * NOTE:
 * <p>
 * 1. If there is a tie, then compare with segment's length and return segment which has maximum length.
 * 2. If there is still a tie, then return the segment with minimum starting index.
 * <p>
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument of input contains an integer array A, of length N.
 * Output Format:
 * <p>
 * Return an array of integers, that is a subarray of A that satisfies the given conditions.
 * Constraints:
 * <p>
 * 1 <= N <= 1e5
 * 1 <= A[i] <= 1e5
 * Examples:
 * <p>
 * Input 1:
 * A = [1, 2, 5, -7, 2, 3]
 * <p>
 * Output 1:
 * [1, 2, 5]
 * <p>
 * Explanation 1:
 * The two sub-arrays are [1, 2, 5] [2, 3].
 * The answer is [1, 2, 5] as its sum is larger than [2, 3].
 * <p>
 * Input 2:
 * A = [10, -1, 2, 3, -4, 100]
 * <p>
 * Output 2:
 * [100]
 * <p>
 * Explanation 2:
 * The three sub-arrays are [10], [2, 3], [100].
 * The answer is [100] as its sum is larger than the other two.
 */
public class MaxNonNegativeSubarray {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        int start = 0, end = 0;
        int prevStart = -1, prevEnd = -1;
        long currSum = 0, maxSum = 0;
        int i = 0;
        while (i < A.size()) {
            if (A.get(i) < 0) {
                ++i;
                start = i;
                end = start;
                currSum = 0;
            } else {
                currSum += A.get(i);
                end = i;
                ++i;
                if (currSum > maxSum) {
                    maxSum = currSum;
                    prevStart = start;
                    prevEnd = end;
                } else if (currSum == maxSum) {
                    if (prevEnd - prevStart < end - start) {
                        prevStart = start;
                        prevEnd = end;
                    } else if (prevEnd - prevStart == end - start && prevStart < start) {
                        prevStart = start;
                        prevEnd = end;
                    }
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        int x = prevStart;
        while (0 <= prevStart && prevStart < A.size() && 0 <= prevEnd && prevEnd < A.size() && x <= prevEnd)
            list.add(A.get(x++));
        return list;
    }

    public static void main(String[] args) {
        MaxNonNegativeSubarray maxNonNegativeSubarray = new MaxNonNegativeSubarray();
        int[] a = {1967513926, 1540383426, -1303455736, -521595368};

        System.out.println(maxNonNegativeSubarray.maxset(toList(a)));
    }

    private static ArrayList<Integer> toList(int[] a) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            list.add(a[i]);
        return list;
    }

}
