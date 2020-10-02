import java.util.LinkedList;
import java.util.Queue;
import java.util.function.BinaryOperator;

/**
 * https://practice.geeksforgeeks.org/problems/inorder-successor-in-bst/1
 *
 * CTCI 4.6
 *
 * Given a BST,  and a reference to a Node x in the BST. Find the Inorder Successor of the given node in the BST.
 *
 *
 * Example 1:
 *
 * Input:
 *       2
 *     /   \
 *    1     3
 *
 * K(data of x) = 2
 *
 * Output: 3
 *
 * Example 2:
 *
 * Input:
 *              20
 *             /   \
 *            8     22
 *           / \
 *          4   12
 *             /  \
 *            10   14
 *
 * K(data of x) = 8
 *
 * Output: 10
 *
 * Explanation:Inorder traversal: 4 8 10 12 14 20 22
 * Hence successor of 8 is 10
 *
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function inOrderSuccessor(). This function takes the root node and the reference node as argument and returns the node that is inOrder successor of the reference node. If there is no successor, return null value.
 *
 *
 * Expected Time Complexity: O(Height of the BST).
 * Expected Auxiliary Space: O(1).
 */
public class InorderSuccessorInBST {
    public static void main(String[] args) {
        Node node15 = new Node(15);
        Node node10 = new Node(10);
        Node node16 = new Node(16);
        Node node1 = new Node(1);
        Node node14 = new Node(14);
        Node node81 = new Node(81);
        Node node8 = new Node(8);
        Node node12 = new Node(12);
        Node node63 = new Node(63);
        Node node94 = new Node(94);
        node63.left = node16;
        node81.left = node63;
        node81.right = node94;
        node8.left = node1;
        node12.right = node14;
        node10.left = node8;
        node10.right = node12;
        node15.left = node10;
        node15.right = node81;
        InorderSuccessorInBST inorderSuccessorInBST = new InorderSuccessorInBST();
        Node res = inorderSuccessorInBST.inorderSuccessor(node15, node14);
        System.out.println("debug");
    }
    public Node inorderSuccessor(Node root,Node x)
    {
        //add code here.
        //find node
        Node succ = null;
        if(x == null || root == null)
            return succ;
        if(x.right != null)
            succ = leftMost(x.right);
        else {
            while(root != null) {
                if(root.data > x.data) {
                    succ = root;
                    root = root.left;
                } else if (root.data < x.data)
                    root = root.right;
                else break;
            }
        }
        return succ;
    }

    public Node leftMost(Node node) {
        if(node.left != null)
            return leftMost(node.left);
        else return node;
    }

    private static class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
}
