import java.util.ArrayList;
import java.util.List;

/**
 *
 * leetcode 68 - https://leetcode.com/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview
 * -150
 *
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth
 * characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra
 * spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not
 * divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 *
 * Example 1:
 *
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 *
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be
 * left-justified instead of fully-justified.
 * Note that the second line is also left-justified because it contains only one word.
 * Example 3:
 *
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art",
 * "is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int start = 0, end = 0;
        int currLength = 0;
        while(end < words.length){
            int delta = (currLength == 0) ? words[end].length() : 1 + words[end].length();
            if(currLength + delta <= maxWidth) {
                currLength += delta;
                if(end == words.length - 1) {
                    StringBuilder sb = new StringBuilder();
                    while(start <= end) {
                        sb.append(words[start]);
                        if(start < end)
                            sb.append(" ");
                        start++;
                    }
                    for(int i = 0; i < maxWidth - currLength; i++)
                        sb.append(" ");
                    ans.add(sb.toString());
                    break;
                }
                end++;
            } else {
                StringBuilder sb = new StringBuilder();
                if(end - start == 1){
                    sb.append(words[start++]);
                    for(int i = 0; i < maxWidth - currLength; i++)
                        sb.append(" ");
                    ans.add(sb.toString());
                } else {
                    int numWords = end - start;
                    int spaces = (maxWidth - currLength)/(numWords - 1);
                    int extras = (maxWidth - currLength)%(numWords - 1);
                    while(start < end) {
                        sb.append(words[start++]);
                        if(start < end){
                            for(int i = 0; i <= spaces; i++)
                                sb.append(" ");
                            if(extras-- > 0)
                                sb.append(" ");
                        }
                    }
                    ans.add(sb.toString());
                }
                currLength = 0;
            }
        }
        return ans;
    }
}
