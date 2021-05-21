package com.company.SynchronizedReadWrite;

import com.company.CommonReadWrite;
import java.util.ArrayList;

public class ReadWrite<T>
{
    CommonReadWrite<T> readWrite = new CommonReadWrite<>();
    private Boolean writing = null;

    public synchronized void write(ArrayList<T> objects, String fileName)
    {
        if(writing == null) {writing = true;}
        while(!writing)
        {
            try
            {
                System.out.println(this.getClass().getName() + " is waiting.");
                wait();
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted " +  e);
            }
        }
        writing = false;
        System.out.println(this.getClass().getName() + " is writing to file.");
        readWrite.writeToFile(objects, fileName);
        notify();
    }

    public synchronized ArrayList<T> read(String fileName)
    {
        if(writing == null) {writing = false;}
        while(writing)
        {
            try
            {
                System.out.println(this.getClass().getName() + " is waiting.");
                wait();
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted " +  e);
            }
        }
        writing = true;
        System.out.println(this.getClass().getName() + " is reading from file.");
        ArrayList<T> objects = readWrite.readFromFile(fileName);
        notify();
        return objects;
    }
}