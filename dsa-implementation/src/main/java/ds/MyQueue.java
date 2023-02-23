package ds;

public class MyQueue<T> {

    Node<T> start;
    Node<T> end;
    private int size;

    public MyQueue(T value) {
        init(value);
    }

    private void init(T value) {
        Node<T> node = new Node<>(value);
        this.start = node;
        this.end = node;
        size++;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return this.start.value;
    }

    public void enqueue(T value) {
        if (size == 0)
            init(value);
        else {
            Node<T> node = new Node<>(value);
            end.next = node;
            end = node;
            size++;
        }
    }

    public T dequeue() {
        if (size == 0) {
            return null;
        }
        if (start == end) {
            end = null;
        }
        T res = start.value;
        start = start.next;
        size--;
        return res;
    }

    public void print() {
        System.out.print("start --> ");
        Node<T> node = this.start;
        while (node != null) {
            System.out.print(node.value + " --> ");
            node = node.next;
        }
        System.out.println("end");
    }

    private class Node<S> {
        S value;
        Node<S> next;

        public Node(S value) {
            this.value = value;
        }
    }

}
