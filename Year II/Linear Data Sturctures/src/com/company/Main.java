package com.company;

import java.util.Random;

public class Main {

    public static void initList(ListVector list)
    {
        Random random = new Random();

        for(int i = 0; i < 15; ++i)
        {
            list.addFirst(random.nextInt(30));
        }
    }

    public static QueueLinked processListConvertToQueue(ListVector list)
    {
        QueueLinked queue = new QueueLinked();
        for(int i = 0; i <= list.getSize(); ++i)
        {
            if(i % 2 == 0)
                list.deleteIndex(i);
        }
        for (int i = 0; i <= list.getSize(); ++i)
        {
            queue.enqueue(list.getIndex(i));
        }
        return queue;
    }

    public static void main(String[] args)
    {

        //first level
        ListVector fList = new ListVector(5);
        fList.addFirst(3);
        fList.addFirst(1);
        fList.addLast(5);
        fList.addIndex(8, 1);
        fList.Show();
        fList.deleteIndex(1);
        fList.deleteFirst();
        fList.deleteLast();
        fList.Show();

        //second level
        QueueLinked fQueue = new QueueLinked();
        fQueue.enqueue(16);
        fQueue.enqueue(42);
        fQueue.enqueue(121);
        fQueue.Show();
        fQueue.dequeue();
        fQueue.dequeue();
        fQueue.Show();

//        //third level
        ListVector myList = new ListVector(14);
        initList(myList);
        QueueLinked queue = processListConvertToQueue(myList);
        queue.Show();
    }
}
