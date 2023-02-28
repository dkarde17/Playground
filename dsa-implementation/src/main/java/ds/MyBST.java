package ds;

public class MyBST<T extends Comparable<T>> {

    private Node<T> root;
    int size;

    public MyBST() {
        this.root = null;
    }

    public void insert(T value) {
        if (root == null)
            root = new Node<>(value);
        else insert(root, value);
        size++;
    }

    private void insert(Node<T> node, T value) {
        if (value.compareTo(node.value) > 0) {
            if (node.right == null)
                node.right = new Node<>(value);
            else insert(node.right, value);
        } else if (value.compareTo(node.value) < 0) {
            if (node.left == null)
                node.left = new Node<>(value);
            else insert(node.left, value);
        }
    }

    public boolean remove(T value) {
        Node<T> parentNode = null;
        Node<T> node = null;
        if (lookup(value)){
            if (value.compareTo(root.value) == 0){
                parentNode = root;
                node = root;
            } else {
                parentNode = findParentNode(root, value);
                if (parentNode == null)
                    throw new IllegalStateException("Node exists so parent " +
                            "can't be null");
                if (parentNode.left != null
                        && parentNode.left.value.compareTo(value) == 0)
                    node = parentNode.left;
                else node = parentNode.right;
                if (node == null)
                    throw new IllegalStateException("node exists so it can't " +
                            "be null");
            }
            removeAndRearrange(parentNode, node);
            return true;
        }
        return false;
    }

    private void removeAndRearrange(Node<T> parentNode, Node<T> node) {
        Node<T> newChild = null;
        if (node.right != null) {
            newChild = node.right;
            if (node.left != null) {
                putInPlace(node.right, node.left);
            }
        } else if (node.left != null) {
            newChild = node.left;
        }
        if (parentNode == node)
            root = newChild;
        else {
            if (parentNode.left != null && parentNode.left.value.compareTo(node.value) == 0)
                parentNode.left = newChild;
            else parentNode.right = newChild;
        }
    }

    private void putInPlace(Node<T> node, Node<T> temp) {
        if (temp.value.compareTo(node.value) < 0){
            if (node.left != null)
                putInPlace(node.left, temp);
            else node.left = temp;
        } else {
            if (node.right != null)
                putInPlace(node.right, temp);
            else node.right = temp;
        }
    }

    private Node<T> findParentNode(Node<T> node, T value) {
        if ((node.left != null && node.left.value.compareTo(value) == 0) ||
            (node.right != null && node.right.value.compareTo(value) == 0))
            return node;
        else if (node.left != null && value.compareTo(node.value) < 0)
            return findParentNode(node.left, value);
        else if (node.right != null && value.compareTo(node.value) > 0)
            return findParentNode(node.right, value);
        else return null;
    }

    public boolean lookup(T value) {
        return lookup(root, value);
    }

    private boolean lookup(Node<T> node, T value) {
        if (node == null)
            return false;
        else if (value.compareTo(node.value) == 0)
            return true;
        else if (value.compareTo(node.value) > 0)
            return lookup(node.right, value);
        else return lookup(node.left, value);
    }

    private class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
        }
    }
}
