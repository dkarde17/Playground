package main;

import ds.MyHashTable;
import ds.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>(10);
        myLinkedList.print();
        System.out.println("*****");

        myLinkedList.add(3);
        myLinkedList.add(6);
        myLinkedList.print();
        System.out.println("*****");

        System.out.println(myLinkedList.get(2));

        System.out.println("*****");

        myLinkedList.delete(1);

        myLinkedList.print();

    }
}
