package com.company;

public class Main {

    public static long Factorial(int number)
    {
        long factorial;
        if(number==0)
        {
            return number+1;
        }
        factorial = number* Factorial(number - 1);
        return factorial;
    }

    public static long Combinations(int n, int m)
    {
        return Factorial(n + m - 1)/(Factorial(m)*Factorial(n-1));
    }

    public static void main(String[] args)
    {
        int ammountOfGroups = 6;
        System.out.println("Task 1");
        System.out.println("Number of combinations: "+ Factorial(6));

        System.out.println("Task 2");
        System.out.println("Number of combinations: " + (Combinations(3,2)*Combinations(5,3)));
    }
}
