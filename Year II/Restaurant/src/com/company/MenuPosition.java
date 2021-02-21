package com.company;

public class MenuPosition
{
    private String name;
    private Integer price;

    public MenuPosition(String name, Integer price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }
    public Integer getPrice()
    {
        return price;
    }

    @Override
    public String toString() {
        return name + " " + price.toString();
    }
}
