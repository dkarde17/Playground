/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] cArr = new int[26];
        for (char c : s.toCharArray())
            cArr[c - 'a']++;
        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            if (cArr[s.charAt(i) - 'a'] == 1) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
