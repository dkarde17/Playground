package main;

import ds.*;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        MyTrie myTrie = new MyTrie();
        myTrie.add("test");
        myTrie.add("this");
        System.out.println(myTrie.exists("this"));
        System.out.println(myTrie.exists("test"));
        System.out.println(myTrie.size());
        System.out.println(myTrie.delete("this"));
        System.out.println(myTrie.delete("test"));
        System.out.println(myTrie.delete("test"));
        myTrie.add("sparta");
        System.out.println(myTrie.size());
    }

    private static void breakLine() {
        System.out.println("*****");
    }
}
