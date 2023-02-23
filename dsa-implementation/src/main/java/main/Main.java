package main;

import ds.MyDoublyLinkedList;
import ds.MyLinkedList;
import ds.MyStack;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>(10);
        myStack.print();
        breakLine();

        myStack.push(5);
        myStack.push(2);
        myStack.print();
        breakLine();

        System.out.println(myStack.peek());
        breakLine();

        myStack.pop();
        myStack.print();
        breakLine();

        System.out.println(myStack.size());
    }

    private static void breakLine() {
        System.out.println("*****");
    }
}
