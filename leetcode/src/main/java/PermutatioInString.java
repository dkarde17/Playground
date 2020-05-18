/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/
 * <p>
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * <p>
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * <p>
 * <p>
 * Note:
 * <p>
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class PermutatioInString {
    public boolean checkInclusion(String s1, String s2) {
        boolean res = false;
        if (s2.length() >= s1.length()) {
            long s1Hash = 0;
            for (char c : s1.toCharArray())
                s1Hash += Math.pow(2, c - 'a');
            long s2Hash = 0;
            for (int i = 0; i < s1.length(); i++)
                s2Hash += Math.pow(2, s2.charAt(i) - 'a');
            int i = s1.length();
            res = s1Hash == s2Hash;
            while (!res && i < s2.length()) {
                s2Hash -= Math.pow(2, s2.charAt(i - s1.length()) - 'a');
                s2Hash += Math.pow(2, s2.charAt(i) - 'a');
                i++;
                if (s1Hash == s2Hash)
                    res = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PermutatioInString permutatioInString = new PermutatioInString();
        System.out.println(permutatioInString.checkInclusion("adc", "dcda"));
    }
}
