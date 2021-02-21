package com.company;

import java.util.List;
import java.util.Scanner;

public class Administrator
{
    private Scanner scanner = new Scanner(System.in);

    private Menu menu;

    Administrator(Menu menu)
    {
        this.menu = menu;
    }

    public void formMenu()
    {
        System.out.println("================================\n" +
                "Administrator is forming today's menu\n" +
                "================================");
        String name;
        int price;
        for (int i = 0; i < 5; ++i)
        {
            System.out.println("Today on menu dish called");
            name = scanner.next();

            System.out.println("Enter position price: ");
            price  = scanner.nextInt();
            menu.addPositionToMenu(name, price);
        }

        System.out.println("================================\n");
        for (var pos:menu.positions)
        {
          System.out.println(pos.toString());
        }
        System.out.println("================================\n");
    }
    public Menu getMenu()
    {
        return menu;
    }

    public void bookTable(List<Table> tables)
    {
        System.out.println("================================\n" +
                "Administrator is booking table\n" +
                "================================");
        System.out.println("We book only 2 tables in advance\nWhich tables are booked today: ");
        int fTableId = scanner.nextInt();
        int sTableId = scanner.nextInt();

        if(fTableId < tables.size() && fTableId >= 0)
        {
            tables.get(fTableId).setVacant(false);
        }
        if(sTableId < tables.size() && sTableId >= 0)
        {
            tables.get(sTableId).setVacant(false);
        }
        System.out.println("================================\n");
        for(var table:tables)
        {
            System.out.println(table.toString());
        }
        System.out.println("================================\n");
    }
    public void occupyTable(List<Table> tables, Customer customer)
    {
        for (int i = 0; i < tables.size(); ++i)
        {
            if(tables.get(i).getVacant())
            {
                tables.get(i).setVacant(false);
                tables.get(i).setCustomer(customer);
                System.out.println("================================\n" +
                        "Administrator is providing table # " + i + " \n" +
                        "================================");
                break;
            }
        }
    }
    public void freeTable(List<Table> tables, Customer customer)
    {
        for(int i = 0; i < tables.size(); ++i)
        {
            if(tables.get(i).getCustomer() != null && tables.get(i).getCustomer().name.equals(customer.name))
            {
                tables.get(i).removeCustomer();
                System.out.println("================================\n" +
                        "Administrator is freeing table # " + i + " \n" +
                        "================================");
                break;
            }
        }
    }
}
