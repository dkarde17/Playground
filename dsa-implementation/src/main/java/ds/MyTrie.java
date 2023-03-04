package ds;

public class MyTrie {

    TrieNode root;

    public void add(String word) {
        if (!exists(root, word)) {
            if (root == null)
                this.root = new TrieNode();
            fill(word, root);
        } else throw new IllegalStateException("Word already exists in the " +
                "dictionary");
    }

    public boolean delete(String word) {
        if (exists(root, word)){
            delete(root, word);
            return true;
        } else return false;
    }

    private void delete(TrieNode node, String word) {
        if (word.length() == 1) {
            TrieNode deleteNode = node.arr[word.charAt(0) - 'a'];
            if (deleteNode.count == 0)
                node.arr[word.charAt(0) - 'a'] = null;
            else deleteNode.count--;
            return;
        }
        delete(node.arr[word.charAt(0) - 'a'], word.substring(1));
        node.count--;
    }

    public int size() {
        if (root == null)
            return 0;
        return root.count;
    }

    private void fill(String string, TrieNode node) {
        if (node.arr[string.charAt(0) - 'a'] == null)
            node.arr[string.charAt(0) - 'a'] = new TrieNode();
        TrieNode trieNode = node.arr[string.charAt(0) - 'a'];
        if (string.length() == 1)
            return;
        fill(string.substring(1), trieNode);
        node.count++;
    }

    public boolean exists(String word) {
        return exists(root, word);
    }

    private boolean exists(TrieNode trieNode, String word) {
        if (trieNode == null)
            return false;
        if (word.length() == 1)
            return trieNode.arr[word.charAt(0) - 'a'] != null;
        return exists(trieNode.arr[word.charAt(0) - 'a'], word.substring(1));
    }

    private class TrieNode {
        int count;
        TrieNode[] arr;

        public TrieNode() {
            arr = new TrieNode[26];
        }

    }
}
