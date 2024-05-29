import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2781 - https://leetcode.com/problems/length-of-the-longest-valid-substring/description/
 *
 * You are given a string word and an array of strings forbidden.
 *
 * A string is called valid if none of its substrings are present in forbidden.
 *
 * Return the length of the longest valid substring of the string word.
 *
 * A substring is a contiguous sequence of characters in a string, possibly empty.
 *
 *
 *
 * Example 1:
 *
 * Input: word = "cbaaaabc", forbidden = ["aaa","cb"]
 * Output: 4
 * Explanation: There are 11 valid substrings in word: "c", "b", "a", "ba", "aa", "bc", "baa", "aab", "ab", "abc" and
 * "aabc". The length of the longest valid substring is 4.
 * It can be shown that all other substrings contain either "aaa" or "cb" as a substring.
 * Example 2:
 *
 * Input: word = "leetcode", forbidden = ["de","le","e"]
 * Output: 4
 * Explanation: There are 11 valid substrings in word: "l", "t", "c", "o", "d", "tc", "co", "od", "tco", "cod", and
 * "tcod". The length of the longest valid substring is 4.
 * It can be shown that all other substrings contain either "de", "le", or "e" as a substring.
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 105
 * word consists only of lowercase English letters.
 * 1 <= forbidden.length <= 105
 * 1 <= forbidden[i].length <= 10
 * forbidden[i] consists only of lowercase English letters.
 */
public class LengthOfTheLongestValidSubstring {
    public int longestValidSubstring(String word, List<String> forbidden) {
        int n = forbidden.size(), min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Set<String> forbs = new HashSet<>();
        for (String temp : forbidden) {
            forbs.add(temp);
            if (temp.length() < min)
                min = temp.length();
            if (temp.length() > max)
                max = temp.length();
        }
        int end = 0, start = 0;
        char[] chars = word.toCharArray();
        int ans = 0;
        while(end < chars.length){
            int leftEnd = end - (min - 1);
            boolean tripWire = true;
            while(leftEnd >= end - (max - 1) && leftEnd >= start) {
                String temp = new String(chars, leftEnd, end - leftEnd + 1);
                if(forbs.contains(temp)) {
                    start = leftEnd + 1;
                    end = Math.max(start, end);
                    tripWire = false;
                    break;
                }
                leftEnd--;
            }
            if (tripWire) {
                ans = Math.max(ans, end - start + 1);
                end++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LengthOfTheLongestValidSubstring obj = new LengthOfTheLongestValidSubstring();
        int ans = obj.longestValidSubstring("leetcode", Arrays.asList("de", "le", "e"));
        System.out.println(ans);
    }
}
