import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapAnagrams = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            int[] freq = new int[26];
            for (char ch : chars)
                freq[ch - 97]++;
            StringBuilder hashBuilder = new StringBuilder();
            for (int f : freq) {
                hashBuilder.append(f);
            }
            String hash = hashBuilder.toString();
            mapAnagrams.computeIfAbsent(hash, (k) -> new ArrayList<String>());
            mapAnagrams.get(hash).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry entry : mapAnagrams.entrySet()) {
            res.add((List<String>) entry.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams.groupAnagrams(strs);
    }

    /**
     * runtime 3ms 
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams_lc(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList();

        HashMap<Integer, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        int[] primes = {
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101
        };

        for (String s : strs) {
            int score = score(s, primes);
            List<String> list = map.get(score);
            if (list == null){
                list = new ArrayList<>();
                map.put(score, list);
                res.add(list);
            }
            list.add(s);
        }
        return res;
    }

    private int score(String s, int[] primes) {
        int score = 1;
        for (char c : s.toCharArray()){
            score *= primes[c-'a'];
        }
        return score;
    }
}
