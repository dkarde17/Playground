/**
 * https://leetcode.com/problems/minimum-length-of-anagram-concatenation/description/
 *
 * 3138. Minimum Length of Anagram Concatenation
 *
 * You are given a string s, which is known to be a concatenation of anagrams of some string t.
 *
 * Return the minimum possible length of the string t.
 *
 * An anagram is formed by rearranging the letters of a string. For example, "aab", "aba", and, "baa" are anagrams of
 * "aab".
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abba"
 *
 * Output: 2
 *
 * Explanation:
 *
 * One possible string t could be "ba".
 *
 * Example 2:
 *
 * Input: s = "cdef"
 *
 * Output: 4
 *
 * Explanation:
 *
 * One possible string t could be "cdef", notice that t can be equal to s.
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consist only of lowercase English letters.
 */
public class MinimumLengthOfAnagramConcatenation {
    public int minAnagramLength(String s) {
        int n = s.length();
        int[][] indexFrequencyHash = new int[n][26];
        char[] chars = s.toCharArray();
        //populate hash
        for(int i = 0; i < n; i++) {
            if(i > 0)
                for(int j = 0; j < 26; j++)
                    indexFrequencyHash[i][j] = indexFrequencyHash[i - 1][j];
            indexFrequencyHash[i][chars[i] - 'a']++;
        }

        int ans = -1;

        //check for min t for which hashes at t intervals are multiples
        for(int t = 1; t <= n; t++) { //starting from 1 check for each t length
            if(n%t == 0){ //if s length is multiple of t length
                int i = 2;
                boolean trip = false;
                while(!trip && t*i <= n){ //for each interval of t indieces
                    //check the frequency hash
                    int j = 0;
                    while(!trip && j < 26 && indexFrequencyHash[t * i - 1][j] == i * indexFrequencyHash[t - 1][j])
                        j++;
                    if (j != 26) { //26 characters not checked
                        trip = true;
                        break;
                    }
                    i++;
                }
                if(!trip){
                    ans = t;
                    break;
                }
            }
        }
        return ans;
    }
}
