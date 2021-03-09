package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String enterDesktopPath()
    {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder("C:\\Users\\d3mag\\Desktop\\");

        System.out.println("Enter name of file in your desktop: ");
        String path = scanner.nextLine();

        return  stringBuilder.append(path).toString();
    }

    public static String readFile(String path) throws  IOException
    {
        File file = new File(path);
        Reader reader = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(reader);

        StringBuilder data = new StringBuilder();
        String s;

        while((s = bufferedReader.readLine()) != null)
        {
            data.append(s + "\n");
        }
        bufferedReader.close();

        return data.toString();
    }

    public static ArrayList<String> getNoSpacesList()
    {
        ArrayList<String> list = new ArrayList<>();
        list.add("abstract");
        list.add("assert");
        list.add("boolean");
        list.add("break");
        list.add("byte");
        list.add("case");
        list.add("catch");
        list.add("char");
        list.add("class");
        list.add("continue");
        list.add("default");
        list.add("do");
        list.add("double");
        list.add("else");
        list.add("extends");
        list.add("final");
        list.add("finally");
        list.add("float");
        list.add("for");
        list.add("if");
        list.add("implements");
        list.add("import");
        list.add("instanceof");
        list.add("int");
        list.add("interface");
        list.add("long");
        list.add("native");
        list.add("new");
        list.add("null");
        list.add("package");
        list.add("private");
        list.add("protected");
        list.add("public");
        list.add("return");
        list.add("short");
        list.add("static");
        list.add("strictfp");
        list.add("super");
        list.add("switch");
        list.add("synchronized");
        list.add("this");
        list.add("throw");
        list.add("throws");
        list.add("transient");
        list.add("try");
        list.add("void");
        list.add("volatile");
        list.add("while");
        list.add("ArrayList<HashSet<Point>>");
        list.add("Point");
        return list;
    }

    public static String processData(String data)
    {
        ArrayList<String> noSpaces = getNoSpacesList();

        StringBuilder stringBuilder = new StringBuilder();

        data = data.trim().replaceAll("\\s+", " ");
        System.out.println(data.toString());
        String[] words = data.split("\\s+");

        String current;

        for(int i = 0; i < words.length; ++i)
        {
            current = words[i];
            stringBuilder.append(current);
            if (noSpaces.contains(current))
            {
                stringBuilder.append(" ");
            }
        }
        return  stringBuilder.toString();
    }

    public static void main(String[] args)
    {
        String path = enterDesktopPath();
        try
        {
            String fileData = readFile(path);
            System.out.println(fileData);
            fileData = processData(fileData);
            System.out.println(fileData);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
