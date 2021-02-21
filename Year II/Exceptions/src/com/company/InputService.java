package com.company;

import java.util.Scanner;

public class InputService
{
    public String getProperStringInput(String valueName) throws InvalidInputException {
        System.out.println("=============================");
        Scanner scanner = new Scanner(System.in);
        String pattern = "^\\w+";

        System.out.println("Enter " + valueName);

        String s = scanner.nextLine();
        if(!s.matches(pattern))
        {
            throw  new InvalidInputException();
        }
        return s;
    }
}
