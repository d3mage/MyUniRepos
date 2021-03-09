package com.company;

public class Student
{
    private String Surname;
    private String Name;
    private int Year;
    private int Stud_ID;
    private String Sex;
    private double Average;

    public int GetID() {return Stud_ID;}
    public int GetYear() {return Year;}
    public String GetSex() {return Sex;}
    public double GetAverage() {return Average;}

    Student(String Surname, String Name, int Stud_ID, int Year, String Sex, double Average)
    {
        this.Surname = Surname;
        this.Name = Name;
        this.Stud_ID = Stud_ID;
        this.Year = Year;
        this.Sex = Sex;
        this.Average = Average;
    }

    @Override
    public String toString() {
        return String.format(Surname + " "  + Name +
                " ID: " + Stud_ID +
                "\nSex: " + Sex + " Year: " + Year +
                " Average: %.2f"
                +"\n=====================================", Average);
    }
}
