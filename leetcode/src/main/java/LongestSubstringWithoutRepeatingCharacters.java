import java.util.HashMap;
import java.util.Map;

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
}
