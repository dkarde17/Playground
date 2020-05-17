import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/
 * <p>
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInAString {
    int[] anagramHash;

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s != null && s.length() >= p.length()) {
            anagramHash = new int[26];
            for (char c : p.toCharArray())
                ++anagramHash[c - 'a'];
            int[] sHashForPLength = new int[26];
            for (int i = 0; i < p.length(); i++)
                ++sHashForPLength[s.charAt(i) - 'a'];
            for (int i = 0; i <= s.length() - p.length(); i++) {
                if (hashEqualsAnagramHash(sHashForPLength))
                    res.add(i);
                --sHashForPLength[s.charAt(i) - 'a'];
                if (i + p.length() < s.length())
                    ++sHashForPLength[s.charAt(i + p.length()) - 'a'];
            }
        }
        return res;
    }

    private boolean hashEqualsAnagramHash(int[] thatHash) {
        boolean isAnagram = anagramHash.length == thatHash.length;
        for (int i = 0; isAnagram && i < anagramHash.length; i++)
            isAnagram = isAnagram && anagramHash[i] == thatHash[i];
        return isAnagram;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();
        System.out.println(findAllAnagramsInAString.findAnagrams("", "a"));
    }
}
