package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HandBook
{
    private  Scanner scanner = new Scanner(System.in);

    private class Recording
    {
        String description;
        String hoursOnRoute;
        Integer cost;

        public Recording(String description, String hoursOnRoute, Integer cost)
        {
            this.description = description;
            this.hoursOnRoute = hoursOnRoute;
            this.cost = cost;
        }

        @Override
        public String toString()
        {
            return "Route: " + description + "\nTime on route: " + hoursOnRoute + "\nCost: " + cost;
        }
    }

    ArrayList<Recording> recordings;

    public HandBook()
    {
        recordings = initRecordings();
    }

    public void addRecord()
    {
        System.out.println("=============================");
        System.out.println("Adding new route record");
        System.out.println("=============================");

        String description = getInput("route description: ", "^[A-Za-z]{4,12}-[A-Za-z]{4,12}");
        String duration = getInput("route duration: ",
                "^(0?\\d|[0,1]\\d|[2][0-4]):([0-6]\\d)-(0?\\d|[0,1]\\d|[2][0-4]):[0-6]\\d");
        System.out.println("Enter route cost");
        int cost = scanner.nextInt();

        recordings.add(new Recording(description, duration, cost));
    }

    public void search()
    {
        System.out.println("Searching for routes costing more than 10: ");
        for(Recording recording : recordings)
        {
            if(recording.cost > 10)
            {
                System.out.println(recording.toString());
            }
        }
    }

    private String getInput(String inputName, String pattern)
    {
        System.out.println("Enter " + inputName);
        String value = scanner.nextLine();

        return Pattern.matches(pattern, value) ? value : "INVALID";
    }

    private ArrayList<Recording> initRecordings()
    {
        int length = 3;

        String[] initDescription = {"Obolon-Vokzal", "Kurenivka-Troyeschina", "Osokorky-Lybidska"};
        String[] initHours = {"6:41-21:49", "7:05-22:18", "7:02-23:52"};
        Integer[] initCost = {10, 5, 12};

        ArrayList<Recording> recordings = new ArrayList<>(length);

        for(int i = 0; i < length; ++i)
        {
            recordings.add(new Recording(initDescription[i], initHours[i], initCost[i]));
        }

        return recordings;
    }

}
