package com.company;

import java.util.Random;

public class Circle
{
    private class Point
    {
        double x;
        double y;
        Point(double x, double y)
        {
            this.x = x;
            this.y = y;
        }
    }

    final private Point centre;
    final private int radius;

    final private double perimeter;
    final private double area;

    public double getPerimeter()
    {
        return  perimeter;
    }
    public  double getArea() {return  area;}

    public Circle()
    {
        Random random = new Random();
        int x  = random.nextInt(20) - 10;
        int y = random.nextInt(20) - 10;
        centre = new Point(x, y);
        radius = random.nextInt(15);
        perimeter = calculatePerimeter();
        area = calculateArea();
    }

    public Circle(int a)
    {
        centre = new Point(0,0);
        radius = 0;
        perimeter = 0;
        area = 0;
    }

    public double calculateArea()
    {
        return radius * radius * 3.14d;
    }
    public double calculatePerimeter()
    {
        return 2 * 3.14d * radius;
    }

    @Override
    public String toString()
    {
        return "\nCentre in point (" + centre.x +";"+centre.y + ")\nRadius: " + radius
                + "\nPerimeter: " + calculatePerimeter() + "\nArea: " + calculateArea() + "\n";
    }

}
