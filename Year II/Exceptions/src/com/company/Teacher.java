package com.company;

import java.util.ArrayList;
import java.util.List;

public class Teacher
{
    public String sex;
    public String surname;
    public String name;
    public String patronymic;
    public ArrayList<String> disciplines;
    public String department;
    public String position;


    public Teacher(String sex, String surname, String name, String patronymic,
                   ArrayList<String> disciplines, String department, String position)
    {
        this.sex = sex;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.disciplines = disciplines;
        this.department = department;
        this.position = position;
    }

    @Override
    public  String toString()
    {
        return "Teacher " + name + " " + surname + " " + patronymic
                + "\nSex: " + sex + "\nDepartment: " + department
                + "\nPosition: " + position + "\nDisciplines: " + disciplines + "\n\n";
    }
}
