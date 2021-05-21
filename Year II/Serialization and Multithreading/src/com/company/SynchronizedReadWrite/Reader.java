package com.company.SynchronizedReadWrite;

import java.util.ArrayList;

public class Reader<T> extends Thread
{
    private ArrayList<T> objects;
    private final ReadWrite<T> readWrite;
    private String fileName;

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public Reader(ArrayList<T> objects, ReadWrite<T> readWrite, String fileName)
    {
        this.objects = objects;
        this.readWrite = readWrite;
        this.fileName = fileName;
    }

    public void run()
    {
        objects = readWrite.read(fileName);
    }
}
