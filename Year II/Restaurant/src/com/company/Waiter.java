package com.company;

public class Waiter
{
    private Menu menu;
    private Order currentOrder;

    public void setMenu(Menu menu)
    {
        this.menu = menu;
    }

    public void greetCustomer(Customer customer)
    {
        System.out.println("================================\n" +
                "Waiter says\n");
        System.out.println("Good day, " + customer.name);
    }

    public void receiveOrder(Customer customer)
    {
        System.out.println("================================\n" +
                "Waiter says\n");
        System.out.println("What would you like to order?");
        currentOrder = customer.giveOrder(menu);
    }
    public void deliverOrder()
    {
        System.out.println("================================\n" +
                "Waiter says\n");
        System.out.println("Here's your " + currentOrder.menuPosition.getName());
        System.out.println("It will cost you " + currentOrder.getPrice().toString());
    }
    public Integer calculatePrice()
    {
        return  currentOrder.getPrice();
    }
}
