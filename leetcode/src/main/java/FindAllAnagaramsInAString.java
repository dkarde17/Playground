import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the
 * answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using
 * all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */
public class FindAllAnagaramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pHash = new int[26];
        int pDistinct = 0; //number of distinct characters in p string
        for (char c : p.toCharArray())
            if (pHash[c - 'a']++ == 0)
                pDistinct++;

        char[] chars = s.toCharArray();
        int start = 0, end = 0, n = chars.length, currDistinct = 0; //number of distinct characters in the running window on s string
        int[] currHash = new int[26]; //current frequency hash of the running window on s string
        List<Integer> ans = new ArrayList<>();
        while (end < n) {
            char currChar = chars[end++];
            int freq = ++currHash[currChar - 'a'];
            if (freq > pHash[currChar - 'a']) {
                while (currHash[currChar - 'a'] > pHash[currChar - 'a'])
                    if (--currHash[chars[start] - 'a'] == pHash[chars[start++] - 'a'] - 1)
                        currDistinct--;
            } else if (freq == pHash[currChar - 'a'] && ++currDistinct == pDistinct) {
                ans.add(start);
                if (--currHash[chars[start] - 'a'] == pHash[chars[start++] - 'a'] - 1)
                    currDistinct--;
            }
        }
        return ans;
    }
}