import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSumII {
    /**
     * Runtime: 2 ms, faster than 41.84% of Java online submissions for Path Sum II.
     * Memory Usage: 42.4 MB, less than 11.35% of Java online submissions for Path Sum II.
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        pathSum(root, sum, res, new ArrayList<>());
        return res;
    }

    public void pathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if(root.left == null && root.right == null) {
            if(sum - root.val == 0) {
                path.add(root.val);
                res.add(path);
            }
            return;
        } else {
            if(root.left != null) {
                List<Integer> leftPath = new ArrayList<>(path);
                leftPath.add(root.val);
                pathSum(root.left, sum - root.val, res, leftPath);
            }
            if(root.right != null) {
                List<Integer> rightPath = new ArrayList<>(path);
                rightPath.add(root.val);
                pathSum(root.right, sum - root.val, res, rightPath);
            }
        }
    }
}
