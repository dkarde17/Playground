/**
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 *
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * Example 2:
 *
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s only contains lower case English letters.
 * 1 <= shift.length <= 100
 * shift[i].length == 2
 * 0 <= shift[i][0] <= 1
 * 0 <= shift[i][1] <= 100
 */
public class PerformStringShifts {
    public String stringShift(String s, int[][] shift) {

        int leftShifts = 0;
        int rightShifts = 0;
        for (int[] shifts: shift) {
            if (shifts[0] == 0)
                leftShifts += shifts[1];
            else rightShifts += shifts[1];
        }
        char[] resultChars = new char[s.length()];
        if (leftShifts > rightShifts){
            leftShifts -= rightShifts;
            leftShifts %= s.length();
            if (leftShifts == 0)
                return s;
            int resultCharPointer = 0;
            for (int i = leftShifts; i < s.length(); i++) {
                resultChars[resultCharPointer++] = s.charAt(i);
            }
            for (int i = 0; i < leftShifts; i++)
                resultChars[resultCharPointer++] = s.charAt(i);
            return String.valueOf(resultChars);
        } else if (rightShifts > leftShifts) {
            rightShifts -= leftShifts;
            rightShifts %= s.length();
            if (rightShifts == 0)
                return s;
            int resultCharPointer = 0;
            for (int i = rightShifts; i >= 1; i--)
                resultChars[resultCharPointer++] = s.charAt(s.length() - i);
            for (int i = 0; i < s.length() - rightShifts; i++)
                resultChars[resultCharPointer++] = s.charAt(i);
            return String.valueOf(resultChars);
        } else return s;
    }

    public static void main(String[] args) {
        String s = "abc";
        int[][] shift = {{0, 1}, {1, 2}};
        PerformStringShifts performStringShifts = new PerformStringShifts();
        System.out.println(performStringShifts.stringShift(s, shift));
    }

    public String rohanSolution(String s, int[][] shift) {
        int sh = 0;
        int n = s.length();
        for (int[] u : shift) {
            if (u[0] == 0) {
                sh = (sh - u[1] + n) % n;
            } else {
                sh = (sh + u[1]) % n;
            }
        }

        char[] ch = new char[n];
        for (int i = 0; i < n; i++) {
            ch[(i + sh) %n] = s.charAt(i);
        }
        return String.valueOf(ch);
    }
}
