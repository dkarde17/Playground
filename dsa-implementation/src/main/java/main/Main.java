package main;

import ds.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>(10);
        myLinkedList.print();
        System.out.println("*****");

        myLinkedList.addTail(3);
        myLinkedList.addTail(6);
        myLinkedList.print();
        System.out.println("*****");

        System.out.println(myLinkedList.get(2));

        System.out.println("*****");

        myLinkedList.delete(1);

        myLinkedList.print();
        System.out.println("*****");

        myLinkedList.addHead(67);
        myLinkedList.print();

    }
}
