import java.util.Stack;

/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/
 *
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> chars = new Stack<>();
        int i = 0;
        while(k > 0 && i < num.length()) {
            Character c = num.charAt(i++);
            if(!chars.isEmpty()) {
                while(!chars.isEmpty() && chars.peek().compareTo(c) > 0 && k > 0) {
                    chars.pop();
                    k--;
                }
                chars.push(c);
            } else chars.push(c);
        }
        while(k > 0 && !chars.isEmpty()) {
            chars.pop();
            k--;
        }
        Stack<Character> reverseChars = new Stack<>();
        while(!chars.isEmpty())
            reverseChars.push(chars.pop());
        while(!reverseChars.isEmpty() && reverseChars.peek() == '0')
            reverseChars.pop();
        StringBuilder sb = new StringBuilder();
        while(!reverseChars.isEmpty()) {
            Character c = reverseChars.pop();
            sb.append(c);
        }
        if(i < num.length())
            sb.append(num.substring(i));
        return sb.length() > 0 ? sb.toString() : "0";
    }

    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        System.out.println(removeKDigits.removeKdigits("1432219", 3));
    }
}
