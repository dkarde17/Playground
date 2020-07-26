/**
 * https://www.geeksforgeeks.org/longest-prefix-also-suffix/
 * <p>
 * Longest prefix which is also suffix
 * Given a string s, find length of the longest prefix which is also suffix. The prefix and suffix should not overlap.
 * <p>
 * Examples:
 * <p>
 * Input : aabcdaabc
 * Output : 4
 * The string "aabc" is the longest
 * prefix which is also suffix.
 * <p>
 * Input : abcab
 * Output : 2
 * <p>
 * Input : aaaa
 * Output : 2
 */
public class LongestPrefixWhichIsAlsoASuffix {
    static int longestPrefixSuffix(String s) {
        int n = s.length();

        if (n < 2) {
            return 0;
        }

        int len = 0;
        int i = n / 2;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                ++len;
                ++i;
            } else {
                if (len == 0) { // no prefix
                    ++i;
                } else {
                    // search for shorter prefixes
                    --len;
                }
            }
        }

        return len;

    }

    // Driver code
    public static void main(String[] args) {
        String s = "abcdefabcb";
        int l = longestPrefixSuffix(s);
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.toString());
        System.out.println(l);
        System.out.println(s.substring(0,l));
    }
}
