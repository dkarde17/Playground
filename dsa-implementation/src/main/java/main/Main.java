package main;

import ds.MyArray;

public class Main {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.push("Hello");
        myArray.push("world");
        myArray.push("!");
        myArray.pop();
        myArray.push("My");
        myArray.push("world");
        myArray.delete(1);
        myArray.insert(2, "dear");
        myArray.print();
    }
}
