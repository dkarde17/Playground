import util.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/submissions/
 * CTCI 4.2
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class ConvertSortedArrayToBinarySearchTree {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
     * Memory Usage: 38.4 MB, less than 99.87% of Java online submissions for Convert Sorted Array to Binary Search Tree.
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        else return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {
        if(end < start)
            return null;
        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, start, mid - 1);
        node.right = buildBST(nums, mid + 1, end);
        return node;
    }
}
