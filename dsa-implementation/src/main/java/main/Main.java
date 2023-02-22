package main;

import ds.MyDoublyLinkedList;
import ds.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> myDoublyLinkedList =
                new MyDoublyLinkedList<>(10);
        myDoublyLinkedList.print();
        System.out.println("*****");

        myDoublyLinkedList.addAtTail(3);
        myDoublyLinkedList.addAtTail(6);
        myDoublyLinkedList.print();
        System.out.println("*****");

        System.out.println(myDoublyLinkedList.get(2));

        System.out.println("*****");

        myDoublyLinkedList.delete(1);

        myDoublyLinkedList.print();
        System.out.println("*****");

        myDoublyLinkedList.addAtHead(67);
        myDoublyLinkedList.print();
        System.out.println("*****");
        System.out.println(myDoublyLinkedList.size());
        System.out.println("*****");

        myDoublyLinkedList.insert(1, 23);
        myDoublyLinkedList.print();
        System.out.println(myDoublyLinkedList.size());
    }
}
