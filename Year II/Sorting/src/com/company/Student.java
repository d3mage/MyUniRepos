package com.company;

public class Student
{
    public String lastName;
    public String firstName;
    public Integer room;


    Student(String lastName, String firstName, Integer room)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.room = room;
    }

    @Override
    public String toString()
    {
        return String.format("Name: " + lastName + " " + firstName + " Room " + room);
    }
}
