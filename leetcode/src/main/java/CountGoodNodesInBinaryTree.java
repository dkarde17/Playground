import util.TreeNode;

/**
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 * <p>
 * Return the number of good nodes in the binary tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes in blue are good.
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root = [3,3,null,4,2]
 * Output: 3
 * Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
 * Example 3:
 * <p>
 * Input: root = [1]
 * Output: 1
 * Explanation: Root is considered as good.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the binary tree is in the range [1, 10^5].
 * Each node's value is between [-10^4, 10^4].
 */
public class CountGoodNodesInBinaryTree {
    int res = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return res;
    }

    private void dfs(TreeNode root, int maxTillNow) {
        if (root == null)
            return;
        else if (root.val >= maxTillNow) {
            res += 1;
            maxTillNow = root.val;
        }
        dfs(root.left, maxTillNow);
        dfs(root.right, maxTillNow);
    }

    public static void main(String[] args) {
        CountGoodNodesInBinaryTree countGoodNodesInBinaryTree = new CountGoodNodesInBinaryTree();
        TreeNode root = new TreeNode(9, null, new TreeNode(3, new TreeNode(6), null));
        System.out.println(countGoodNodesInBinaryTree.goodNodes(root));
    }


}
