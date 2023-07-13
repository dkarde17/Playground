/**
 * leetcode 6 - https://leetcode.com/problems/zigzag-conversion/?envType=study-plan-v2&envId=top-interview-150
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
 * display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */
public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        char[] chars = new char[s.length()];
        int j = 0;
        int freq = (numRows - 1) * 2;
        int ogFreq = freq;
        if(numRows == 1)
            return s;
        for(int i = 0; i < numRows && i < s.length(); i++) {
            chars[j++] = s.charAt(i);
            if(i == 0 || i == numRows - 1){
                int next = i + ogFreq;
                while(next < s.length()) {
                    chars[j++] = s.charAt(next);
                    next += ogFreq;
                }
            } else {
                int next = i + freq;
                int nextFreq = ogFreq - freq;
                while(next < s.length()) {
                    chars[j++] = s.charAt(next);
                    if(next + nextFreq < s.length()){
                        next+= nextFreq;
                        chars[j++] = s.charAt(next);
                    } else break;
                    next += freq;
                }
            }
            freq = freq-2;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(ZigzagConversion.convert("A", 1));
    }
}
