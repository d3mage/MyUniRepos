package com.company;

public class HashTable
{
    private  Circle[] vector;
    private  int size;

    private  Circle emptyCircle = new Circle(0);

    public HashTable(int size)
    {
        vector = new Circle[size];
        this.size = size;
    }

    private int hash1(Circle circle)
    {
        int key = (int)circle.getPerimeter();
        return  key % size;
    }
    private  int hash2(Circle circle)
    {
        int key = (int)circle.getPerimeter();
        int prime = (int) size / 2;
        return prime - (key % prime);
    }

    public boolean insert(Circle circle)
    {
        int index = hash1(circle);
        if (vector[index] == null || vector[index].equals(emptyCircle))
        {
            vector[index] = circle;
            return true;
        }
        else
        {
            if(!vector[index].equals(circle)) {return collision(index, circle);}
            return false;
        }
    }

    private boolean collision(int hash1, Circle circle) {
        int index;
        int hash2 = hash2(circle);
        for(int i = 1; i < vector.length; i++)
        {
            index = (hash1 + i * hash2) % size;
            if(vector[index] == null)
            {
                vector[index] = circle;
                return true;
            }
            if(vector[index].equals(circle)) return false;
        }
        return false;
    }

    public void remove(double area)
    {
        for(int i = 0; i < size; ++i)
        {
            if(vector[i] != null && vector[i] != emptyCircle)
            {
                if(vector[i].getArea() < area) { vector[i] = emptyCircle;}
            }
        }
    }

    public void show()
    {
        for (int i = 0; i < size; ++i)
        {
            if (vector[i] != null)
            {
                System.out.println("Index: " + i  + vector[i].toString());
            }
        }
    }
}
