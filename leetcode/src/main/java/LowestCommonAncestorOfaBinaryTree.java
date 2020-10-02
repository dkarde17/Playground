import util.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * CTCI 4.7
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 *
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 */
public class LowestCommonAncestorOfaBinaryTree {
    TreeNode res;

    /**
     * Runtime: 4 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * Memory Usage: 41.1 MB, less than 89.01% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root, p, q);
        return res;
    }

    public boolean lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return false;
        boolean one = lca(root.left, p, q);
        boolean two = lca(root.right, p, q);
        if(one && two) {
            res = root;
            return true;
        }
        if((one || two) && (root.val == p.val || root.val == q.val)) {
            res = root;
            return true;
        }
        if(root.val == p.val || root.val == q.val || one || two)
            return true;
        return false;
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode2.left = treeNode7;
        treeNode2.right = treeNode4;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode2;
        treeNode1.left = treeNode0;
        treeNode1.right = treeNode8;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode1;

        LowestCommonAncestorOfaBinaryTree lowestCommonAncestorOfaBinaryTree = new LowestCommonAncestorOfaBinaryTree();
        TreeNode treeNode = lowestCommonAncestorOfaBinaryTree.lowestCommonAncestor(treeNode3, treeNode5, treeNode4);
        System.out.println("debug");
    }
}
