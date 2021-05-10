package com.company;

import java.time.LocalDate;

public class Student {
    String Surname;
    String Sex;
    int LibraryCard;
    LocalDate ExpirationDate;

    Student (String Surname, String Sex, int LibraryCard, LocalDate ExpirationDate){
        this.Surname = Surname;
        this.Sex = Sex;
        this.LibraryCard = LibraryCard;
        this.ExpirationDate = ExpirationDate;
    }


    @Override
    public String toString(){
        return Surname + " " + Sex + " " + LibraryCard + " " + ExpirationDate;
    }
}

