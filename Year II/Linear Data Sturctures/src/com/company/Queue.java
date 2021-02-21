package com.company;

public class Queue
{
    private String [] vector;
    private int last;

    public Queue(int size)
    {
        vector = new String[size];
        last = -1;
    }

    public boolean isFull()
    {
        return  last == vector.length - 1;
    }
    public boolean isEmpty()
    {
        return last == -1;
    }

    public boolean enqueue(int value)
    {
        if(isFull()) return  false;

        String hex = Integer.toHexString(value);
        vector[++last] = hex;
        return true;
    }
    public String dequeue()
    {
        if(isEmpty()) return null;

        String temp = vector[0];
        for(int i = 0; i < last; ++i)
        {
            vector[i] = vector[i + 1];
        }
        vector[last--] = null;
        return  temp;
    }

    public void Show()
    {
        for(int i = 0; i <= last; ++i)
        {
            System.out.printf(vector[i] + " ");
        }
        System.out.println();
    }
}
