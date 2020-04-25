import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache( 2 ); //2 is capacity
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class LRUCache {
    Node mostRecent, leastRecent;
    private final int LRU_CAPACITY;
    private Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.LRU_CAPACITY = capacity;
        cache = new HashMap<>(LRU_CAPACITY);
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        Node node = cache.get(key);
        removeNode(node);
        moveToTheTop(node);
        return node.value;
    }

    private void moveToTheTop(Node node) {
        node.left = mostRecent;
        node.right = null;
        if (mostRecent != null) {
            mostRecent.right = node;
        }
        if (leastRecent == null) {
            leastRecent = node;
        }
        mostRecent = node;
    }

    //TODO: learn LRU cache implementation
    private void removeNode(Node node) {
        if (node.left != null) {
            node.left.right = node.right;
        } else leastRecent = node.right;
        if (node.right != null) {
            node.right.left = node.left;
        } else mostRecent = node.left;
    }

    public void put(int key, int value) {
        Node node;
        if (cache.containsKey(key)) {
            node = cache.get(key);
            node.value = value;
            removeNode(node);
        } else node = new Node(key, value);
        if (cache.size() == LRU_CAPACITY && !cache.containsKey(key)) {
            cache.remove(leastRecent.key);
            removeNode(leastRecent);
        }
        cache.put(key, node);
        moveToTheTop(node);
    }

    private class Node {
        final int key;
        int value;
        Node left;
        Node right;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        lruCache.get(1);
        lruCache.get(2);
    }
}


/*
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
