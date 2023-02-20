package main;

import ds.MyHashTable;

public class Main {
    public static void main(String[] args) {
        MyHashTable myHashTable = new MyHashTable(5);
        System.out.println("*******");
        myHashTable.printHashTable();
        System.out.println("*******");

        myHashTable.set("xa", "divye");
        myHashTable.set("wanchi", "yesh");
        myHashTable.printHashTable();
        System.out.println("*****");

        myHashTable.set("wakanda", "forever");

        System.out.println("value of key xa = " + myHashTable.get("xa"));

        System.out.println("*****");

        myHashTable.set("thisis" ,"sparta");
        myHashTable.set("phir", "hera pheri");
        myHashTable.set("collission", "pakka hua");
        myHashTable.printHashTable();

        System.out.println("*******");
        System.out.println(myHashTable.keys().toString());
    }
}
