package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main
{
    public static Student[] initStudents(int size)
    {
        Random random = new Random();
        ArrayList<String> surnames = new ArrayList<>()
        {
            {
                add("Sotnyk");
                add("Rybak");
                add("Morkva");
                add("Melnyk");
                add("Boyko");
                add("Shevchenko");
                add("Lomachinskiy");
                add("Kramarenko");
            }
        };

        ArrayList<Student> students = new ArrayList<>();

        String surname;
        String sex;
        int libraryCard;
        LocalDate expirationDate;

        for(int i = 0; i < size; ++i)
        {
            surname = surnames.get(random.nextInt(surnames.size()));
            sex = (i < size / 2) ? "male" : "female";
            libraryCard = i;
            expirationDate =  LocalDate.of(2021, random.nextInt(11) + 1, random.nextInt(30) + 1);
            students.add(new Student(surname, sex, libraryCard, expirationDate));
        }
        return  students.toArray(new Student[0]);
    }

    public static Student search(Student [] students, int key)
    {
        return find(students, 0, students.length -1, key);
    }
    public static Student find(Student[] arr, int left, int right, int key)
    {
        if(left > right){ return null; }
        if(left == right){ return null; }

        int med = left + (right - left) * (key - arr[left].LibraryCard)/(arr[right].LibraryCard - arr[left].LibraryCard);

        if(arr[med].LibraryCard == key)
        {
            return arr[med];
        }

        if(arr[med].LibraryCard > key)
        {
            return find(arr, left, med - 1, key);
        }
        else
        {
            return find(arr, med+1, right, key);
        }
    }

    public static void performTask(Student[] students, int key)
    {
        String isExpired = isMaleCardExpired(students, key);
        System.out.println(isExpired + "\n");
    }

    public static String  isMaleCardExpired(Student[] students, int key)
    {
        Student student = search(students, key);
        if(student == null ) { return  "Student wasn't found"; }
        if(student.Sex.equals("female")) {return "Card belongs to female"; }
        return checkExpiredCard(student) ? "Card expired" : "Card is valid";
    }

    public static boolean checkExpiredCard(Student student)
    {
        return  student.ExpirationDate.isBefore(LocalDate.now());
    }

    public static void main(String[] args)
    {
        Random random = new Random();
        int size = 26;

        Student[] students = initStudents(size);
        for (Student student : students)
        {
         System.out.println(student.toString());
        }
        System.out.println();

        int nextKey = random.nextInt(size);
        System.out.println("Next key: " + nextKey);
        performTask(students, nextKey);

        BST bst = new BST();
        for(int i = 0; i < 5; ++i)
        {
            bst.insert(students[i]);
            bst.insert(new Student("Vovk", "male", 122334, LocalDate.of(2021, 7, 20)));
        }
        bst.find(LocalDate.of(2021, 7, 20));

        BSTR bstr = new BSTR();
        for(int i = 0; i < 5; ++i)
        {
            bstr.insert(students[i]);
            bstr.insert(new Student("Vovk", "male", 122334, LocalDate.of(2021, 7, 20)));
        }
        bstr.find(LocalDate.of(2021, 7, 20));
    }
}
