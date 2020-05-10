/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 14
 * Output: false
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long low = 0, high = num/2 + 1;
        while(low <= high) {
            long mid = low + (high - low)/2;
            long midSqr = mid * mid;
            if(num == midSqr)
                return true;
            else if( num < midSqr)
                high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        System.out.println(validPerfectSquare.isPerfectSquare(808201));
    }
}
