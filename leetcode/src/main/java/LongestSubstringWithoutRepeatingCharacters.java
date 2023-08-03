import java.util.HashSet;
import java.util.Set;


/**
 * 3. Longest Substring Without Repeating Characters
 * Medium
 * 35.9K
 * 1.6K
 * Companies
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 *
 * leetcode 3 : https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        int start = 0, end = 0, ans = 0, n = s.length();
        int[] count = new int[256];
        while(end < n){
            count[c[end++]]++;
            while(count[c[end-1]] > 1)
                count[c[start++]]--;
            ans = Math.max(end - start, ans);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        char[] c = s.toCharArray();
        int start = 0, end = 0, ans = 0, counter = 0, n = s.length();
        int[] count = new int[256];
        while(end < n){
            if(count[c[end++]]++ > 0)
                counter++;
            while(counter > 0)
                if(count[c[start++]]-- > 1)
                    counter--;
            ans = Math.max(end - start, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
    }

    public int leetCodeSolution(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
