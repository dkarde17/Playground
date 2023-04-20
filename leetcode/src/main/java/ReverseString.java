/**
 * Write a function that reverses a string. The input string is given as an
 * array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra
 * memory.
 *
 * https://leetcode.com/problems/reverse-string/description/
 */
public class ReverseString {
    /**
     * using recursive approach
     * @param s
     */
    public void reverseString(char[] s) {
        int n = s.length;
        int i = 0;
        reverse(s, i, n-1);
    }

    public void reverse(char[] s, int i, int n) {
        if(i == s.length)
            return;
        char c = s[i];
        reverse(s, i+1, n-1);
        s[n] = c;
    }
}
