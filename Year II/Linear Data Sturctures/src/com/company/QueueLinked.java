package com.company;

import javax.management.QueryEval;
import java.util.ArrayList;
import java.util.Collections;

public class QueueLinked
{
    private class QueueNode
    {
        String data;
        QueueNode prev;

        QueueNode(String data)
        {
            this.data = data;
        }
    }

    private QueueNode firstNode;
    private  QueueNode lastNode;
    private int size = -1;

    public int getSize() {return size;}
    public boolean isEmpty() {return  lastNode == null;}

    public void enqueue(int value)
    {
        String hex = Integer.toHexString(value);
        QueueNode newNode = new QueueNode(hex);
        size++;
        if (isEmpty())
        {
            firstNode = lastNode = newNode;
        }
        lastNode.prev = newNode;
        lastNode = newNode;
    }

    public String dequeue()
    {
        if(isEmpty()) return  null;

        QueueNode temp = firstNode.prev;
        firstNode = temp;
        if(isEmpty())
            lastNode = firstNode;
        size--;
        return  temp.data;
    }

    public void Show()
    {
        QueueNode currentNode = firstNode;
        for (int i = 0; i <= size; ++i) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.prev;
        }
        System.out.println();
    }
}
