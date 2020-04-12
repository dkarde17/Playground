import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 * <p>
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 * <p>
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 * <p>
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 * <p>
 * Can you solve it in O(N) time and O(1) space?
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = new Stack<Character>();
        Stack<Character> tStack = new Stack<Character>();
        for (char c : S.toCharArray()) {
            if (c != '#') {
                sStack.push(c);
            }
            else if (!sStack.empty()) {
                sStack.pop();
            }
        }
        for (char c : T.toCharArray()) {
            if (c != '#') {
                tStack.push(c);
            }
            else if (!tStack.empty()) {
                tStack.pop();
            }
        }
        return sStack.equals(tStack);
    }

    public static void main(String[] args) {
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
         backspaceStringCompare.backspaceCompare("xywrrmp","xywrrmu#p");
    }
}
