import util.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * CTCI 4.5
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
     * Memory Usage: 38.3 MB, less than 99.67% of Java online submissions for Validate Binary Search Tree.
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, int min, int max) {
        boolean ans = true;
        if(node == null)
            return ans;
        ans = node.val > min && node.val < max;
        if(!ans)
            return ans;
        else return ans && isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}
