package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public  static ArrayList<Student> initStudents()
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
            }
        };
        ArrayList<String> names = new ArrayList<>()
        {
            {
                add("Dmytro");
                add("Liudmyla");
                add("Vasyl");
                add("Ivan");
                add("Mariya");
            }
        };

        String surname, name;
        int stud_ID;
        int year;
        String sex;
        double average;

        ArrayList<Student> students = new ArrayList<>();
        for(int i = 0; i < 10; ++i)
        {
            surname = surnames.get(random.nextInt(surnames.size()));
            name = names.get(random.nextInt(names.size()));
            stud_ID = random.nextInt(1000000);
            year = random.nextInt(4) + 1;
            sex = (random.nextInt(2) == 0) ? "male" : "female";
            average = 1.0 + (5.0 - 1.0) * random.nextDouble();
            students.add(new Student(surname, name, stud_ID, year, sex, average));
        }

        return students;
    }

    public static void main(String[] args)
    {
        ArrayList<Student> students = initStudents();
        BinaryTree binaryTree = new BinaryTree();
        for (Student student : students)
        {
            binaryTree.add(student);
        }
        binaryTree.print();
        System.out.println();
        System.out.println("List of findable students :");
        System.out.println(binaryTree.find());
        System.out.println();
        binaryTree.delete();
        binaryTree.print();
    }
}
