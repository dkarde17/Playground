/**
 * https://leetcode.com/problems/sqrtx/
 *
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 */
public class Sqrtx {
    public int mySqrt(int x) {
        long left = 1, right = x;
        long mid = 0;
        while(left <= right) {
            mid = left + (right - left)/2;
            long product = mid * mid;
            if(product == x)
                return (int)mid;
            else if(product < x)
                left = mid + 1;
            else right = mid - 1;
        }
        return (int) (left + right)/2;
    }

    public static void main(String[] args) {
        Sqrtx sqrtx = new Sqrtx();
        System.out.println(sqrtx.mySqrt(8));
    }

    /**
     * O(sqrt(n))
     *
     * public int mySqrt(int x) {
     *         int max = Integer.MAX_VALUE;
     *         int i = 0;
     *         while (i * i <= max) {
     *             if(i * i == x || (i * i < x  && (i + 1) > x / (i + 1))) {
     *                 return i;
     *             }
     *             i++;
     *         }
     *         return 0;
     *     }
     */
}
