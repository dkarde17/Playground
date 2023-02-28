package main;

import ds.*;

public class Main {
    public static void main(String[] args) {
        MyBST<Integer> bst = new MyBST<>();
        bst.insert(10);

        System.out.println("debug line");

        bst.insert(5);
        bst.insert(6);
        bst.insert(15);
        bst.insert(12);
        bst.insert(16);
//        bst.remove(10);

        System.out.println("debug line");

    }

    private static void breakLine() {
        System.out.println("*****");
    }
}
