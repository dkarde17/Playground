package ds;

import jdk.internal.foreign.abi.BindingInterpreter;

public class MyStack<T> {
    Node<T> top;
    Node<T> bottom;
    private int size;

    public MyStack(T firstValue) {
        init(firstValue);
        size++;
    }

    private void init(T value) {
        Node<T> firstNode = new Node<>(value, null);
        this.top = firstNode;
        this.bottom = firstNode;
    }

    public T peek() {
        if (size == 0)
            return null;
        else return this.top.value;
    }

    public T pop() {
        if (size == 0)
            return null;
        Node<T> node = top;
        top = top.next;
        size--;
        return node.value;
    }

    public void push(T value) {
        if (size == 0)
            init(value);
        else {
            Node<T> node = new Node<>(value, top);
            this.top = node;
            size++;
        }
    }

    public void print() {
        System.out.println("Top");
        Node<T> node = this.top;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
        System.out.println("bottom");
    }

    public int size() {
        return size;
    }

    private class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
