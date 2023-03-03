package main;

import ds.*;

public class Main {
    public static void main(String[] args) {
        MyMaxHeap myMaxHeap = new MyMaxHeap(5);
        myMaxHeap.insert(2);
        myMaxHeap.insert(3);
        myMaxHeap.insert(1);
        myMaxHeap.insert(10);
        myMaxHeap.insert(15);

        System.out.println(myMaxHeap.peek());
        System.out.println(myMaxHeap.poll());
        System.out.println(myMaxHeap.poll());
        System.out.println(myMaxHeap.poll());
        System.out.println(myMaxHeap.poll());
        System.out.println(myMaxHeap.poll());
        System.out.println(myMaxHeap.poll());
    }

    private static void breakLine() {
        System.out.println("*****");
    }
}
