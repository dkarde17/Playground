import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 *
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 *
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, AtomicInteger> wordCount = new HashMap<>();
        for(String word : words) {
            if(!wordCount.containsKey(word))
                wordCount.put(word, new AtomicInteger(1));
            else wordCount.get(word).incrementAndGet();
        }
        PriorityQueue<WordCount> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.count < o2.count)
                return 1;
            else if(o2.count < o1.count)
                return -1;
            else return o1.word.compareTo(o2.word);
        });
        wordCount.forEach((word, count) -> {
            pq.offer(new WordCount(word, count.get()));
        });
        List<String> topKWords = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            topKWords.add(pq.poll().word);
        }
        return topKWords;
    }

    private class WordCount{
        String word;
        Integer count;
        public WordCount(String word, Integer count) {
            this.word = word;
            this.count = count;
        }
    }
}
