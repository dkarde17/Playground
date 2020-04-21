import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 */
public class ValidParanthesisString {
    public boolean checkValidString(String s) {
        int minOpenLeft = 0, maxOpenLeft = 0;
        for(char c : s.toCharArray()) {
            if (c == '(') {
                minOpenLeft++;
                maxOpenLeft++;
            } else if (c == '*') {
                minOpenLeft--;
                maxOpenLeft++;
            } else {
                minOpenLeft--;
                maxOpenLeft--;
            }
            if (maxOpenLeft < 0)
                return false;
            minOpenLeft = Math.max(0, minOpenLeft);
        }
        return minOpenLeft == 0;
    }

    public static void main(String[] args) {
        ValidParanthesisString validParanthesisString = new ValidParanthesisString();
        System.out.println(validParanthesisString.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
    }
}
