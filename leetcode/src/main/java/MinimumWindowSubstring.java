/**
 * leetcode 76 - https://leetcode.com/problems/minimum-window-substring/
 *
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 *  of s such that every character in t (including duplicates) is included in the window. If there is no such
 *  substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 *
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int start = 0, end = 0, counter = 0, left = 0, right = 0, d = Integer.MAX_VALUE;
        int[] arr = new int[128];
        for(char c : t.toCharArray()) {
            arr[c]++;
            counter++;
        }
        char[] charr = s.toCharArray();
        while(end < charr.length) {
            if(arr[charr[end++]]-- > 0)
                counter--;
            while(counter == 0 && start < end ){
                if(arr[charr[start++]]++ == 0)
                    counter++;
                if(end - start < d){
                    right = end;
                    left = start - 1;
                    d = right - left;
                }
            }
        }
        return s.substring(left, right);
    }
}
