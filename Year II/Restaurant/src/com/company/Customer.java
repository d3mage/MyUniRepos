package com.company;

import java.util.Scanner;

public class Customer
{
    String name;

    public Customer(String name)
    {
        this.name = name;
    }

    public Order giveOrder(Menu menu)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("================================\n");
        System.out.println(name + " responds");
        System.out.println("I'd like to have : ");

        boolean ordered = false;
        String position = " ";

        Order order = new Order();
        while (ordered != true)
        {
            position = scanner.next();
            for(var pos : menu.positions)
            {
                if (pos.getName().equals(position))
                {
                    order.setMenuPosition(pos);
                    return  order;
                }
            }
            System.out.println("Invalid menu position");
        }
        return order;
    }

    public void eat()
    {
        System.out.println(name+" eats...");
    }
}
