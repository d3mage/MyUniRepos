package com.company;

public class Order
{
    MenuPosition menuPosition;

    public void setMenuPosition(MenuPosition menuPosition)
    {
        this.menuPosition = menuPosition;
    }

    public Integer getPrice()
    {
        return menuPosition.getPrice();
    }
}
