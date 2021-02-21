package com.company;

public class Main {

    public static void main(String[] args)
    {
        Menu menu = new Menu();

        Administrator administrator = new Administrator(menu);
        Waiter waiter = new Waiter();

        Customer fCustomer = new Customer("Dmytro");
        Customer sCustomer = new Customer("Lyudmyla");
        Restaurant restaurant = new Restaurant(administrator, waiter);
        restaurant.open();
        restaurant.customerVisit(fCustomer);
        restaurant.customerVisit(sCustomer);
        restaurant.closed();
    }
}
