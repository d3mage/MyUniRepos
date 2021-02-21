package com.company;

import java.util.ArrayList;

public class Restaurant
{
    private Administrator administrator;
    private Waiter waiter;
    private ArrayList<Table> tables;

    private Integer dailyProfit;

    public Restaurant(Administrator administrator, Waiter waiter)
    {
        this.administrator = administrator;
        this.waiter = waiter;
        tables = new ArrayList<>(6);
        for(int i = 0; i < 6; ++i)
        {
            tables.add(new Table(true, i));
        }
        dailyProfit = 0;
    }

    public void open()
    {
        administrator.formMenu();
        administrator.bookTable(tables);
        waiter.setMenu(administrator.getMenu());
    }

    public void customerVisit(Customer customer)
    {
        waiter.greetCustomer(customer);
        administrator.occupyTable(tables, customer);
        waiter.receiveOrder(customer);
        waiter.deliverOrder();
        customer.eat();
        dailyProfit += waiter.calculatePrice();
        administrator.freeTable(tables, customer);
    }
    public void closed()
    {
        System.out.println("Today's profit : " + dailyProfit.toString());
    }
}
