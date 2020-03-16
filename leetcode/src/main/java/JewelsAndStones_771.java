import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones_771 {
    public int numJewelsInStones(String J, String S) {
        char[] stones = S.toCharArray();
        Map<Character, Integer> characterCount = new HashMap<>();
        for(char stone : stones) {
            characterCount.compute(stone, (k,v) -> v == null ? 1 : v+1);
        }
        char[] jewels = J.toCharArray();
        int count = 0;
        for(char jewel : jewels) {
            count += characterCount.getOrDefault(jewel, 0);
        }
        return count;
    }

    public int solution2(String J, String S) {
        char[] stones = S.toCharArray();
        int[] counts = new int[123];
        for(char stone : stones) {
            counts[(int) stone]++;
        }
        char[] jewels = J.toCharArray();
        int count = 0;
        for(char jewel : jewels) {
            count += counts[(int) jewel];
        }
        return count;
    }
}
