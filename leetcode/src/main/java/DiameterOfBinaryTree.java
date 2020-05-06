/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * Example:
 * Given a binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {

    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }
    public int depth(TreeNode node) {
        if (node == null)
            return 0;
        int leftDepth = depth(node.left);
        int righDepth = depth(node.right);
        int currentMaxDiameter = leftDepth + righDepth;
        if (currentMaxDiameter > ans)
            ans = currentMaxDiameter;
        return Math.max(leftDepth, righDepth) + 1;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        TreeNode treeRoot = diameterOfBinaryTree.constructTree();
        System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(treeRoot));
    }

    private TreeNode constructTree() {
        return new TreeNode(3, new TreeNode(1,
                null,
                new TreeNode(2, null, null)),
                null
        );
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }
}
