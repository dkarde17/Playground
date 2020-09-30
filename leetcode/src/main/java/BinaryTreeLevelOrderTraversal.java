import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * CTCI = 4.3
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * Runtime: 1 ms, faster than 61.44% of Java online submissions for Binary Tree Level Order Traversal.
     * Memory Usage: 39.6 MB, less than 72.13% of Java online submissions for Binary Tree Level Order Traversal.
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> temp = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) {
                result.add(new ArrayList(temp));
                temp = new ArrayList<>();
                queue.add(null);
                if(queue.peek() == null)
                    break;
                else continue;
            } else {
                temp.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
        }
        return result;
    }
}
