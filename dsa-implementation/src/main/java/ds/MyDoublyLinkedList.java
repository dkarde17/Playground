package ds;

import jdk.vm.ci.meta.SpeculationLog;

public class MyDoublyLinkedList<T> {
    Node head;
    Node tail;
    private int size;

    public MyDoublyLinkedList(T value) {
        head = new Node(value, null, null);
        tail = head;
        size++;
    }

    public void addAtHead(T value) {
        Node newNode = new Node(value, null, head);
        head.prev = newNode;
        head = newNode;
        size++;
    }

    public void addAtTail(T value) {
        Node newNode = new Node(value, tail, null);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void insert(int index, T value) {
        int i = 0;
        Node node = head;
        Node prevNode = null;
        while(i < index) {
            prevNode = node;
            node = node.next;
            i++;
        }
        Node newNode = new Node(value, prevNode, node);
        node.prev = newNode;
        if (prevNode != null) {
            prevNode.next = newNode;
        }
        if (i == 0)
            head = newNode;
        size++;
    }

    public T delete(int index) {
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
        node.next.prev = prevNode;
        size--;
        return node.value;
    }

    public T get(int index) {
        int i = 0;
        Node node = head;
        while(i < index) {
            node = node.next;
            i++;
        }
        return node.value;
    }

    public void print() {
        Node node = head;
        while(node != null) {
            System.out.print(node.value);
            if (node.next != null)
                System.out.print("<-->");
            else System.out.println();
            node = node.next;
        }
    }


    public int size() {
        return size;
    }

    private class Node{
        T value;
        Node prev;
        Node next;

        public Node(T value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
