import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/path-sum-iii/
 *
 * CTCI 4.12
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSumIII {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
//        calculateForTarget(root, sum); //approach 1

        Map<Integer, Integer> hashTable = new HashMap<>();
        hashTable.put(0, 1);
        dfs(root, sum, hashTable, 0); //approach 2 more optimized using hashtables to store the prefix sum
        return count;
    }


    /**
     * Runtime: 3 ms, faster than 70.17% of Java online submissions for Path Sum III.
     * Memory Usage: 39.1 MB, less than 82.95% of Java online submissions for Path Sum III.
     * @param root
     * @param sum
     * @param hashTable
     * @param runningSum
     */
    public void dfs(TreeNode root, int sum, Map<Integer, Integer>  hashTable, int runningSum) {
        if(root == null)
            return;
        runningSum += root.val;
        if(hashTable.containsKey(runningSum - sum))
            count += hashTable.get(runningSum - sum);
        hashTable.computeIfPresent(runningSum, (k, v) -> v + 1);
        hashTable.computeIfAbsent(runningSum, k -> 1);
        dfs(root.left, sum, hashTable, runningSum);
        dfs(root.right, sum, hashTable, runningSum);
        hashTable.computeIfPresent(runningSum, (k, v) -> v - 1);
    }

    /**
     * Runtime: 22 ms, faster than 29.44% of Java online submissions for Path Sum III.
     * Memory Usage: 39 MB, less than 86.99% of Java online submissions for Path Sum III.
     * @param root
     * @param sum
     */
    public void calculateForTarget(TreeNode root, int sum) {
        if(root == null)
            return;
        calculateForRunningSum(root, sum, 0);
        calculateForTarget(root.left, sum);
        calculateForTarget(root.right, sum);
    }

    public void calculateForRunningSum(TreeNode root, int sum, int currSum) {
        if(root == null)
            return;
        currSum += root.val;
        if(currSum == sum)
            count++;
        calculateForRunningSum(root.left, sum, currSum);
        calculateForRunningSum(root.right, sum, currSum);
    }

    public static void main(String[] args) {
        PathSumIII pathSumIII = new PathSumIII();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;
        System.out.println(pathSumIII.pathSum(node1, 3));
    }
}
