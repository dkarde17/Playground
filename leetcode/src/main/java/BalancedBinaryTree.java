import util.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * CTCI 4.4
 *
 *
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int depth = getDepth(root);
        if(depth == -1)
            return false;
        else return true;
    }

    public int getDepth(TreeNode node) {
        if(node == null) return 0;
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        if(left == -1 || right == -1 || left - right > 1 || right - left > 1)
            return -1;
        else return Math.max(left, right) + 1;
    }
}
