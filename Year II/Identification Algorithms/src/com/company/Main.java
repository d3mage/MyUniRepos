package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    public static ArrayList <String> ReadFile(String file)
    {
        ArrayList<String> array = new ArrayList<>();

        try(FileInputStream fis = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(fis);
            BufferedReader read = new BufferedReader(reader))
        {
            String line = read.readLine();
            while(line!=null)
            {
                array.add(line);
                line = read.readLine();
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return array;
    }

    public static ArrayList<String> readFileWithSplittingTextInWords(String nameFile)
    {
        ArrayList<String> list = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(nameFile));)
        {
            String s;
            while ((s = bufferedReader.readLine())!= null)
            {
                list.add(s);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        String pattern = "\\s|,|\\.";
        ArrayList <String> words = new ArrayList<>();
        for (String line: list)
        {
            String[] splitResult;
            splitResult = line.split(pattern);
            words.addAll(Arrays.asList(splitResult));
        }
        return words;
    }

    public static void main(String[] args)
    {
        String file = "file.txt";
        ArrayList<String> text = ReadFile(file);
        String regular = "^([\\[])([+]|[-])([0-9A-Z]+)([\\]])$";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher;
        for (String s : text)
        {
            matcher = pattern.matcher(s);
            System.out.print(s + " ");
            if (matcher.find())
            {
                System.out.println("true");
            } else
                {
                System.out.println("false");
            }
        }

        Automat automat = new Automat("$ABB..");
        System.out.println(automat.scanner());

        ArrayList<String> words = readFileWithSplittingTextInWords("FSM.txt");
        for(String word : words)
        {
            TransitTable transitTable = new TransitTable(word);
            System.out.println(word + " " + transitTable.scanner());

        }
    }
}
