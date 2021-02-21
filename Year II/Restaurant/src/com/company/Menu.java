package com.company;

import java.util.ArrayList;

public class Menu
{
    ArrayList<MenuPosition> positions;

    Menu()
    {
        positions = new ArrayList<>(5);
    }

    public void addPositionToMenu(String name, Integer price)
    {
        positions.add(new MenuPosition(name, price));
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder(positions.get(0).toString());
        for (int i = 1; i < positions.size(); ++i)
        {
            builder.append(positions.get(i).toString() + "\n");
        }
        return builder.toString();
    }
}
