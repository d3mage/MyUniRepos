package com.company;

import java.io.*;
import java.util.ArrayList;

public class CommonReadWrite<T>
{
    public void writeToFile(ArrayList<T> objects, String fileName)
    {
        try
        {
            FileOutputStream writeData = new FileOutputStream(fileName);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(objects);
            writeStream.flush();
            writeStream.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<T> readFromFile(String fileName)
    {
        ArrayList<T> array = new ArrayList<>();
        try
        {
            FileInputStream readData = new FileInputStream(fileName);
            ObjectInputStream readStream = new ObjectInputStream(readData);

            array = (ArrayList<T>) readStream.readObject();
            readStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return array;
    }
}
