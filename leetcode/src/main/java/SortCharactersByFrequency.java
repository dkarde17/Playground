import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3337/
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> characterCount = new HashMap<>();
        for (char c : s.toCharArray())
            characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
        PriorityQueue<Character> characters = new PriorityQueue<>((a, b) -> characterCount.get(b) - characterCount.get(a));
        characters.addAll(characterCount.keySet());
        StringBuilder sb = new StringBuilder();
        while (!characters.isEmpty()){
            Character c = characters.poll();
            for (int i = 0; i < characterCount.get(c); i++)
                sb.append(c);
        }
        return sb.toString();
    }
}
