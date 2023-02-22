package ds;

public class MyLinkedList<T> {
    Node head;
    Node tail;
    private int size;

    public MyLinkedList(T firstValue){
        this.head = new Node(firstValue, null);
        size++;
        this.tail = head;
    }

    public void addTail(T value) {
        tail.next = new Node(value, null);
        size++;
        tail = tail.next;
    }

    public void addHead(T value) {
        Node node = new Node(value, head);
        size++;
        head = node;
    }

    public T get(int index) {
        Node result = null;
        int i = 0;
        Node node = head;
        while(i < index) {
            node = node.next;
            i++;
        }
        result = node;
        return result != null ? result.value : null;
    }

    public T delete(int index) {
        Node result = null;
        int i = 0;
        Node node = head;
        Node prevNode = null;
        while(i < index) {
            prevNode = node;
            node = node.next;
            i++;
        }
        if (prevNode != null) {
            prevNode.next = node.next;
        }
        size--;
        node.next = null;
        result = node;
        return result != null ? result.value : null;
    }

    public void insert(int index, T value) {
        Node node = head;
        Node prevNode = null;
        int i = 0;
        while (i < index) {
            prevNode = node;
            node = node.next;
            i++;
        }
        Node newNode = new Node(value, node);
        if (prevNode != null) {
            prevNode.next = newNode;
        }
        if (i == 0)
            head = newNode;
        size++;
    }

    public void print() {
        Node node = head;
        while(node != null) {
            System.out.print(node.value);
            if (node != tail)
                System.out.print("-->");
            else System.out.println();
            node = node.next;
        }
    }

    public int size() {
        return size;
    }

    private class Node {
        T value;
        Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
