package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void FillArray(int length, double[][] myArray)
    {
        Random random = new Random();

        for(int i = 0; i < length; ++i)
        {
            for (int j = 0; j < length; j++)
            {
                myArray[i][j] = random.nextDouble() * 100;
            }
        }
    }
    public static void PrintArray(int length, double[][] myArray)
    {
        for(int i = 0; i < length; ++i)
        {
            for (int j = 0; j < length; j++)
            {
                System.out.printf("%2.4f ", myArray[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void RotateArray(int length, double [][]myArray)
    {
        for(int i = 0; i < (length + 1 ) / 2; ++i)
        {
            for (int j = 0; j < length / 2; j++)
            {
                double temp = myArray[length - 1 - j][i];
                myArray[length - 1 - j][i] = myArray[length - 1 - i][length - j - 1];
                myArray[length - 1 - i][length - j - 1] = myArray[j][length - 1 -i];
                myArray[j][length - 1 - i] = myArray[i][j];
                myArray[i][j] = temp;
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sotnyk D.S. ");
        System.out.println("Enter length of matrix: ");
        int length = scanner.nextInt();

        double[][] myArray = new double[length][length];

        FillArray(length, myArray);
        PrintArray(length, myArray);
        RotateArray(length, myArray);
        PrintArray(length, myArray);
    }




}
