import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * https://leetcode.com/problems/closest-leaf-in-a-binary-tree/
 * <p>
 * Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf node to target k in the tree.
 * <p>
 * Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.
 * <p>
 * In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * root = [1, 3, 2], k = 1
 * Diagram of binary tree:
 * 1
 * / \
 * 3   2
 * <p>
 * Output: 2 (or 3)
 * <p>
 * Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
 * Example 2:
 * <p>
 * Input:
 * root = [1], k = 1
 * Output: 1
 * <p>
 * Explanation: The nearest leaf node is the root node itself.
 * Example 3:
 * <p>
 * Input:
 * root = [1,2,3,4,null,null,null,5,null,6], k = 2
 * Diagram of binary tree:
 * 1
 * / \
 * 2   3
 * /
 * 4
 * /
 * 5
 * /
 * 6
 * <p>
 * Output: 3
 * Explanation: The leaf node with value 3 (and not the leaf node with value 6) is nearest to the node with value 2.
 * Note:
 * root represents a binary tree with at least 1 node and at most 1000 nodes.
 * Every node has a unique node.val in range [1, 1000].
 * There exists some node in the given binary tree for which node.val == k
 */
public class ClosestLeafNodeInABinaryTree {

    public static void main(String[] args) {
        ClosestLeafNodeInABinaryTree closestLeafNodeInABinaryTree = new ClosestLeafNodeInABinaryTree();
        TreeNode one = new TreeNode(1, null, null);
        TreeNode two = new TreeNode(2, null, null);
        TreeNode three = new TreeNode(3, null, null);
        TreeNode four = new TreeNode(4, null, null);
        TreeNode five = new TreeNode(5, null, null);
        TreeNode six = new TreeNode(6, null, null);
        TreeNode seven = new TreeNode(7, null, null);
        TreeNode eight = new TreeNode(8, null, null);
        TreeNode nine = new TreeNode(9, null, null);
        TreeNode ten = new TreeNode(10, null, null);
        one.left = two;
        one.right = three;
        three.left = four;
        three.right = five;
        four.left = six;
        five.right = seven;
        six.left = eight;
        six.right = nine;
        seven.left = ten;
        int closestLeaf = closestLeafNodeInABinaryTree.findClosestLeaf(one, 4);
        System.out.println(closestLeaf);
    }

    int ans, distance = Integer.MAX_VALUE;

    /**
     * Runtime: 3 ms, faster than 71.97% of Java online submissions for Closest Leaf in a Binary Tree.
     * Memory Usage: 38.9 MB, less than 54.78% of Java online submissions for Closest Leaf in a Binary Tree.
     * @param root
     * @param k
     * @return
     */
    public int findClosestLeaf(TreeNode root, int k) {
        int res;
        TreeNode target = bfs(root, k);

        //now we need to calculate the distance of the target node from it's own children leaf and it's parent's children leaf

        // 1. Calculating the distance from it's own children leaf node
        if (target.left == null && target.right == null)
            return target.val;

        dfs(target, 0);

        res = ans;

        parentDFS(root, target, new AtomicBoolean(false));

        res =  ans;
        return res;
    }

    private LeafData parentDFS(TreeNode root, TreeNode target, AtomicBoolean targetFound) {
        if (root == target || root.left == null && root.right == null) {
            if (root == target)
                targetFound.set(true);
            return new LeafData(root.val, 1);
        } else {
            AtomicBoolean leftFound = new AtomicBoolean(false);
            AtomicBoolean rightFound = new AtomicBoolean(false);
            LeafData left = root.left == null ? null : parentDFS(root.left, target, leftFound);
            LeafData right = root.right == null ? null : parentDFS(root.right, target, rightFound);
            if (leftFound.get()) {
                if (right != null) {
                    if (left.distance + right.distance < distance) {
                        ans = right.val;
                    }
                }
                left.distance += 1;
                return left;
            } else if (rightFound.get()) {
                if (left != null) {
                    if (left.distance + right.distance < distance) {
                        ans = left.val;
                    }
                }
                right.distance += 1;
                return right;
            }
            if (root.right == null || left != null && left.distance <= right.distance) {
                left.distance += 1;
                return left;
            }
            else  {
                right.distance += 1;
                return right;
            }
        }
    }

    private class LeafData {
        int val;
        int distance;

        public LeafData(int val, int distance) {
            this.val = val;
            this.distance = distance;
        }
    }

    private void dfs(TreeNode target, int depth) {
        if (target.left == null && target.right == null) {
            if (depth < distance){
                distance = depth;
                ans = target.val;
            }
            return;
        }
        if (target.left != null)
            dfs(target.left, depth + 1);
        if (target.right != null)
            dfs(target.right, depth + 1);
    }

    private TreeNode bfs(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode ans = null;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.val == k) {
                ans = temp;
                break;
            }
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
        return ans;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
