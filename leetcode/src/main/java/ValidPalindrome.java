/**
 * leetcode 125 https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
 * non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and
 * numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        boolean ans = true;
        while(left < right) {
            while( left < s.length() && !isAlphanumeric(s, left))
                left++;
            while( right >= 0 && !isAlphanumeric(s, right))
                right--;
            if(left < s.length() && right >= 0 && !equal(s, left, right)) {
                ans = false;
                break;
            } else {
                left++;
                right--;
            }
        }
        return ans;
    }

    public boolean isAlphanumeric(String s, int index) {
        char c = s.charAt(index);
        return ( c >= 48 && c <= 57 ) || ( c >= 65 && c <= 90 ) || (c >= 97 && c <= 122);
    }

    public boolean equal(String s, int left, int right) {
        char l = s.charAt(left);
        char r = s.charAt(right);
        if (l == r)
            return true;
        else if ( l >= 65 && l <= 90 )
            return r - 32 == l;
        else if ( l >= 97 && l <= 122 )
            return l - 32 == r;
        else return false;
    }
}
