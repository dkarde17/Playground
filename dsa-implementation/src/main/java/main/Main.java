package main;

import ds.MyDoublyLinkedList;
import ds.MyLinkedList;
import ds.MyQueue;
import ds.MyStack;

public class Main {
    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<>("This");
        myQueue.print();
        breakLine();

        myQueue.enqueue("is");
        myQueue.enqueue("Sparta!");
        myQueue.enqueue("!!!");
        myQueue.enqueue("!!!");
        myQueue.print();
        breakLine();

        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        myQueue.print();
        breakLine();

        System.out.println(myQueue.size());

    }

    private static void breakLine() {
        System.out.println("*****");
    }
}
