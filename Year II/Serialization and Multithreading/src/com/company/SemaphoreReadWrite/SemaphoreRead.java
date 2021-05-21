package com.company.SemaphoreReadWrite;

import com.company.CommonReadWrite;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class SemaphoreRead<T> extends Thread {
    CommonReadWrite<T> commonReadWrite = new CommonReadWrite<>();
    private  final Semaphore semaphore;
    private ArrayList<T> objects;
    private String fileName;

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public SemaphoreRead(ArrayList<T> objects, Semaphore semaphore, String fileName)
    {
        this.objects = objects;
        this.semaphore = semaphore;
        this.fileName = fileName;
    }

    public void run()
    {
        try
        {
            System.out.println(this.getClass().getName() + " is waiting.");
            semaphore.acquire();
            System.out.println(this.getClass().getName() + " taking semaphore.");
            System.out.println(this.getClass().getName() + " is reading from file.");
            commonReadWrite.readFromFile(fileName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getClass().getName() + " releasing semaphore.");
        semaphore.release();
    }
}

