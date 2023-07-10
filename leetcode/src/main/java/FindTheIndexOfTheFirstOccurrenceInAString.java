/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 *
 * Constraints:
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 *
 * leetcode 28 - https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        int i = 0;
        while(i < haystack.length()) {
            int j = 0;
            while((i + j) < haystack.length() && j < needle.length() && haystack.charAt(i + j) == needle.charAt(j))
                j++;
            if(j == needle.length())
                return i;
            i++;
        }
        return -1;
    }
}
