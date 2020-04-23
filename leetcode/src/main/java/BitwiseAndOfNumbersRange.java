/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 *
 * Example 1:
 *
 * Input: [5,7]
 * Output: 4
 * Example 2:
 *
 * Input: [0,1]
 * Output: 0
 */
public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        /*
        if the most significant bit of the two numbers is different then the result will be zero
        because while going from the smaller number to the bigger number all the bits will have flipped
        at least once.
        if the msot significant bit of the two numbers is same that means that they're in the same power of 2 range
        and the result will have at least that bit position as 1 because all the numbers in that range will have 1
        at that position. So add that weight = Math.pow(2, msb) to the result and then subtract the weight from
        both m and n and continue.
         */

        int msb_m = -1, msb_n = -1;
        int res = 0;
        do {
            msb_m = mostSignificantDigit(m);
            msb_n = mostSignificantDigit(n);
            if(msb_m == msb_n) {
                int weight = (int) Math.pow(2, msb_m);
                res += weight;
                m -= weight;
                n -= weight;
            }
        } while (msb_m == msb_n && msb_m != -1 && (m > 0 && n > 0));
        return res;
    }

    private int mostSignificantDigit(int n) {
        int count = -1;
        while(n > 0){
            n = n >> 1;
            count++;
        }
        return count;
    }
}
