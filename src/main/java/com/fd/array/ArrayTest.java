package com.fd.array;


public class ArrayTest {

    public static void main(String[] args) {

        IArray myArray = new NormanArray(10);
        myArray.insert(0);
        myArray.insert(1);
        myArray.insert(2);
        myArray.insert(3);
        myArray.insert(4);
        myArray.insert(5);
        myArray.insert(6);
        myArray.insert(7);
        myArray.insert(8);
        myArray.insert(9);

        myArray.display();

        myArray.exits(10);
        myArray.exits(9);

        System.err.println("========================================");
        try {
            myArray.insert(1,10);
        } catch (IndexOutOfBoundsException e) {
            myArray.delete(1);
            myArray.display();
        }

        System.err.println("========================================");
        myArray.insert(1,10);
        myArray.display();

        System.err.println("========================================");
        myArray.update(9,90);
        myArray.display();


    }


}
