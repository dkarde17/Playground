import java.util.Queue;

public class CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree {
    boolean valid = false;
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if(arr == null || arr.length == 0)
            return false;
        else{
            isValidSequence(root, arr, 0);
            return valid;
        }
    }

    private void isValidSequence(TreeNode root, int[] arr, int pos) {
        if (!valid && pos < arr.length && root != null){
            if (root.val == arr[pos]) {
                if (pos == arr.length - 1 && root.left == null && root.right == null)
                    valid = true;
                isValidSequence(root.left, arr, pos + 1);
                isValidSequence(root.right, arr, pos + 1);
            }
        }
    }

    private static class TreeNode {
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
