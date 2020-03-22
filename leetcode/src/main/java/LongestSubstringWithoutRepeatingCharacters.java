import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int longestSubstring = 0;
        int currentLength = 0;
        int currentStart = 0;
        Map<Character, Integer> charPresent = new HashMap<>();
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(!charPresent.containsKey(c)) {
                charPresent.put(c, i);
                currentLength++;
            } else {
                int prevIndex = charPresent.get(c);
                if(prevIndex >= currentStart) {
                    if(currentLength > longestSubstring)
                        longestSubstring = currentLength;
                    currentStart = prevIndex + 1;
                    currentLength = i - currentStart + 1;
                } else currentLength++;
                charPresent.replace(c, i);
            }

        }
        if(currentLength > longestSubstring)
            longestSubstring = currentLength;
        return longestSubstring;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
    }

    public int leetCodeSolution(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
