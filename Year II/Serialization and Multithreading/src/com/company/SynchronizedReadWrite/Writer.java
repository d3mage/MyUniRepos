package com.company.SynchronizedReadWrite;

import java.util.ArrayList;

public class Writer<T> extends Thread
{
    private final ArrayList<T> objects;
    private final ReadWrite<T> readWrite;
    private String fileName;

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public Writer(ArrayList<T> objects, ReadWrite<T> readWrite, String fileName)
    {
        this.objects = objects;
        this.readWrite = readWrite;
        this.fileName = fileName;
    }

    public void run()
    {
        readWrite.write(objects, fileName);
    }
}
