import util.TreeNode;

/**
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * <p>
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * <p>
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * <p>
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 */
public class CousinsInBinaryTree {
    int xDepth = -1, yDepth = -1;
    int xParent = -1, yParent = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        xParent = root.val;
        yParent = root.val;
        dfs(root, x, y, 0, 0);
        if(xDepth == yDepth && xDepth != -1 && xParent != yParent)
            return true;
        else return false;
    }
    private void dfs(TreeNode root, int x, int y, int depth, int parentVal) {
        if(root == null)
            return;
        else if(root.val == x) {
            xDepth = depth;
            xParent = parentVal;
            return;
        }
        else if(root.val == y) {
            yDepth = depth;
            yParent = parentVal;
            return;
        }
        dfs(root.left, x, y, depth + 1, root.val);
        dfs(root.right, x, y, depth + 1, root.val);
    }

}
