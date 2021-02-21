package com.company;

import java.awt.*;
import java.util.*;

public class Main
{
    public static void initHashSets(ArrayList<HashSet<Point>> hashSets, int sets, int points)
    {

        for(int i = 0; i < sets; ++i)
        {
            HashSet<Point> newHashSet = new HashSet<>(points);

            for(int j = 0; j < points; ++j)
            {
                Point newPoint = getNewPoint();
                newHashSet.add(newPoint);
            }

            hashSets.add(newHashSet);
        }
    }
    public static Point getNewPoint()
    {
        Random random = new Random();
        int x = random.nextInt(5);
        int y = random.nextInt(5);
        return  new Point(x, y);
    }

    public static void printHashSets(ArrayList<HashSet<Point>> hashSets)
    {
        for(HashSet<Point> hashSet : hashSets)
        {
            for (Point point : hashSet)
            {
                System.out.println(point.toString());
            }
            System.out.println("\n");
        }
    }

    public static void findOccurance(ArrayList<HashSet<Point>> hashSets, int sets, int points)
    {
        HashSet<Point> firstHashSet = hashSets.get(0);
        HashSet<Point> currentHashSet;

        ArrayList<Point> repeatedPoints = new ArrayList<>(0);

        for(int i = 1; i < sets; ++i)
        {
            currentHashSet = hashSets.get(i);
            for (Point currentSetPoint : currentHashSet)
            {
                for(Point firstSetPoint : firstHashSet)
                {
                    if (firstSetPoint.x == currentSetPoint.x && firstSetPoint.y == currentSetPoint.y)
                    {
                        repeatedPoints.add(currentSetPoint);
                    }
                }
            }
        }

        int biggestAmount = -1;
        Point biggestPoint = null;

        for (Point point : repeatedPoints)
        {
            int amountOfPoints = Collections.frequency(repeatedPoints, point);
            if (amountOfPoints > biggestAmount)
            {
                biggestAmount = amountOfPoints;
                biggestPoint = point;
            }
        }
        System.out.println("Point " + (biggestPoint == null ? " was not found"
                : biggestPoint.toString() + " was found " + biggestAmount + " times"));
    }



    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter amount of sets: ");
        int sets = scanner.nextInt();
        System.out.println("Enter amount of points in each set: ");
        int points = scanner.nextInt();

        ArrayList<HashSet<Point>> hashSets = new ArrayList<HashSet<Point>>(sets);
        initHashSets(hashSets, sets, points);
        printHashSets(hashSets);
        findOccurance(hashSets, sets, points);
    }
}
