package com.company;

import java.util.Random;

public class Main {

    public static Circle[] initCircles(int size)
    {
        Random random = new Random();
        Circle[] circles = new Circle[size];

        int x, y, radius;

        for (int i = 0; i < size; ++i) {
            x = random.nextInt(20) - 10;
            y = random.nextInt(20) - 10;
            radius = random.nextInt(15);
            circles[i] = new Circle(x, y, radius);
        }

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
