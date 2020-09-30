import util.TreeNode;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * Output: 6
 * Example 2:
 * <p>
 * Input: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * Output: 42
 */
public class BinaryTreeMaximumPathSum {
    int maxSum;
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        else maxSum = root.val;
        traverseTree(root);
        return maxSum;
    }

    private int traverseTree(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int leftSum = traverseTree(root.left);
            int rightSum = traverseTree(root.right);
            maxSum = Math.max(maxSum, Math.max(leftSum + rightSum, Math.max(leftSum, rightSum)) +  root.val);
            return Math.max(root.val, Math.max(leftSum + root.val, rightSum + root.val));
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(9);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(-3);
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        System.out.println(binaryTreeMaximumPathSum.maxPathSum(treeNode));
    }
}
