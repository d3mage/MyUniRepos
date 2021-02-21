package com.company;

public class Table
{
    private Integer number;

    private boolean isVacant;
    private Customer customer;

    public Table(boolean vacant, Integer number)
    {
        this.number = number;
        isVacant = vacant;
    }

    public void setVacant(boolean vacant)
    {
        isVacant = vacant;
    }
    public boolean getVacant()
    {
        return  isVacant;
    }

    public void setCustomer(Customer customer) {this.customer = customer;}
    public Customer getCustomer() {return customer;}
    public void removeCustomer() {this.customer = null;}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Table #");
        builder.append(number);
        builder.append(getVacant() ? " vacant" : " occupied");
        return builder.toString();
    }
}
