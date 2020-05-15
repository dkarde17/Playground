/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3329/
 *
 * Implement Trie (Prefix Tree)
 * Solution
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class ImplementTrie {
    /** Initialize your data structure here. */
    Node root;
    public ImplementTrie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(root, word, 0);
    }

    private void insert(Node node, String word, int pos) {
        Node currNode = node.nodes[word.charAt(pos) - 'a'];
        if(currNode == null) {
            currNode = new Node();
            node.nodes[word.charAt(pos) - 'a'] = currNode;
        }
        if(pos == word.length() - 1) {
            currNode.setPresent();
            return;
        }
        insert(currNode, word, ++pos);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node currNode = startsWith(root, word, 0);
        return currNode != null && currNode.present;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWith(root, prefix, 0) != null;
    }

    public Node startsWith(Node node, String prefix, int pos) {
        Node currNode = node.nodes[prefix.charAt(pos) - 'a'];
        if(node == null || currNode == null)
            return null;
        else if (pos == prefix.length() - 1 && currNode != null)
            return currNode;
        else return startsWith(currNode, prefix, ++pos);
    }

    private class Node{
        boolean present;
        Node[] nodes;
        public Node(){
            nodes = new Node[26];
        }

        void setPresent(){
            present = true;
        }
    }

    public static void main(String[] args) {
        ImplementTrie implementTrie = new ImplementTrie();
        implementTrie.insert("apple");
        System.out.println(implementTrie.search("apple"));

    }
}
