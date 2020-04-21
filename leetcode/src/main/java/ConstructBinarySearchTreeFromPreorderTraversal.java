import java.util.concurrent.atomic.AtomicInteger;

/**
 * Return the root node of a binary search tree that matches the given preorder traversal.
 * <p>
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= preorder.length <= 100
 * The values of preorder are distinct.
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {
    int indexTracker = 0;

    public static void main(String[] args) {
        ConstructBinarySearchTreeFromPreorderTraversal constructBinarySearchTreeFromPreorderTraversal = new ConstructBinarySearchTreeFromPreorderTraversal();
        int[] preorder = {4, 2};
        TreeNode root = constructBinarySearchTreeFromPreorderTraversal.bstFromPreorder(preorder);
        System.out.println("wait for debug");
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, preorder[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorder(int[] preorder, int data, int min, int max) {
        if (indexTracker < preorder.length) {
            if (preorder[indexTracker] > min && preorder[indexTracker] < max) {
                TreeNode node = new TreeNode(preorder[indexTracker++]);
                if (indexTracker < preorder.length) {
                    node.left = bstFromPreorder(preorder, preorder[indexTracker], min, data);
                }
                if (indexTracker < preorder.length) {
                    node.right = bstFromPreorder(preorder, preorder[indexTracker], data, max);
                }
                return node;
            }
        }
        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
