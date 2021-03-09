package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static String getDirectory()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file directory: ");
        return scanner.nextLine();
    }
    public static void processDirectory(String path)
    {
        File directory = new File(path);
        if (directory.exists() && directory.isDirectory())
        {
        processDirectory(directory);
        }
        else
        {
        System.out.println("Current path directory is invalid.");
        }
    }

    public synchronized static void processDirectory(File directory)
    {
        File[] files = directory.listFiles(x -> x.getName().endsWith(".txt"));
        if (files == null)
        {
            System.out.println("No files available.");
            return;
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(File f : files)
        {
            executorService.execute(() -> {
                try (BufferedReader reader = new BufferedReader(new FileReader(f)))
                {
                    int amountOfNumbers = 0;
                    String currentLine;
                    while((currentLine = reader.readLine()) != null)
                    {
                        currentLine = currentLine.replaceAll("[^0-9]+", " ");
                        amountOfNumbers += currentLine.trim().split(" ").length;
                    }
                    if(amountOfNumbers != 0)
                    {
                        writeToFile(f, amountOfNumbers);
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        System.out.println("Result file path: C:/Users/d3mag/Desktop/output.txt");
    }

    public static  void writeToFile(File f, int amount) throws IOException
    {
        try (FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/d3mag/Desktop/output.txt", true);)
        {
            fileOutputStream.write((LocalDateTime.now().toString() +
                    " File: " + f.getName() + " contains " + amount + " numbers.\n")
                    .getBytes(StandardCharsets.UTF_8));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        String path = getDirectory();
        processDirectory(path);
    }
}
