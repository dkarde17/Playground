import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 *
 * CTCI 4.10
 *
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 *
 *
 * Example 2:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 */
public class SubtreeOfAnotherTree {
    /**
     * Runtime: 6 ms, faster than 35.63% of Java online submissions for Subtree of Another Tree.
     * Memory Usage: 38.9 MB, less than 98.75% of Java online submissions for Subtree of Another Tree.
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> probable = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(s);
        boolean found = false;
        while(!queue.isEmpty() && !found) {
            TreeNode node = queue.poll();
            if(node.val == t.val)
                probable.add(node);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
            while(!probable.isEmpty() && !found) {
                found = checkEqual(probable.poll(), t);
            }
        }
        return found;
    }

    public boolean checkEqual(TreeNode x, TreeNode t) {
        if(x == null || t == null)
            return t == null && x == null;
        else return (x.val == t.val) && checkEqual(x.left, t.left) && checkEqual(x.right, t.right);
    }
}
