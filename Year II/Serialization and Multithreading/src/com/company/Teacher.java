package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Teacher implements Serializable
{
    String name;
    String surname;
    String paternal;
    String sex;
    ArrayList<String> disciplines;
    String cathedra;
    String chair;

    public Teacher(String name, String surname, String paternal, String sex,
                   ArrayList<String> disciplines, String cathedra, String chair)
    {
        this.name = name;
        this.surname = surname;
        this.paternal = paternal;
        this.sex = sex;
        this.disciplines = disciplines;
        this.cathedra = cathedra;
        this.chair = chair;
    }

    @Override
    public String toString()
    {
        return name + " " + surname + " " + paternal + " " + sex + "\n"
                + disciplines + "\n" + cathedra + " " + chair + "\n";
    }
}
