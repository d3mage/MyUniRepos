package com.company;

import java.util.Random;

public class Main {

    public static Circle[] initCircles(int size)
    {
        Circle[] circles = new Circle[size];

        for (int i = 0; i < size; ++i) {circles[i] = new Circle();}

        return circles;
    }

    public static void hashCircles(Circle[] circles, HashTable hashTable)
    {
        for(Circle circle : circles)
        {
            hashTable.insert(circle);
        }
    }

    public static void main(String[] args)
    {
        Circle[] circles = initCircles(10);

        HashTable hashTable = new HashTable(15);
        hashCircles(circles, hashTable);
        hashTable.show();
        hashTable.remove(150);
        hashTable.show();
    }
}
