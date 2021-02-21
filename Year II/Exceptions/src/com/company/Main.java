package com.company;

import java.util.List;
import java.util.stream.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static ArrayList<Teacher> InitTeachers()
    {
        Random random = new Random();
        InputService inputService = new InputService();

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
        ArrayList<String> departments = new ArrayList<>()
        {
            {
                add("Philology");
                add("Mathematics");
                add("IT");
                add("Innovations");
                add("Economics");
            }
        };
        ArrayList<String> positions = new ArrayList<>()
        {
            {
              add("Docent");
              add("PhD");
              add("Vice rector");
              add("Lecturer");
            }
        };

        int amountOfTeachers = 3;
        ArrayList<Teacher> teachers = new ArrayList<>(amountOfTeachers);

        for(int i = 0; i < amountOfTeachers; ++i)
        {
            String sex = (random.nextInt(2) == 0) ? "male" : "female";
            String surname = surnames.get(random.nextInt(surnames.size()));
            String department = departments.get(random.nextInt(departments.size()));
            String position = positions.get(random.nextInt(positions.size()));
            try
            {
                String name = inputService.getProperStringInput("name");
                String patronymic = inputService.getProperStringInput("patronymic");

                int amountOfDisciplines = random.nextInt(2 + 1);
                ArrayList<String> disciplines = new ArrayList<>(amountOfDisciplines);
                for (int j = 0; j < amountOfDisciplines; ++j)
                {
                    disciplines.add(inputService.getProperStringInput("discipline"));
                }
                teachers.add(new Teacher(sex, surname, name, patronymic, disciplines, department, position));
                System.out.flush();
            }
            catch (InvalidInputException e)
            {
                System.out.println(e.message);
            }
        }
            return teachers;
    }

    public static ArrayList<Teacher> getByDepartment(ArrayList<Teacher> teachers, String department)
    {
        List<Teacher> stream = teachers.stream()
                .filter(x -> x.department.equalsIgnoreCase(department))
                .collect(Collectors.toList());
        return new ArrayList<>(stream);
    }
    public static ArrayList<Teacher> getByDiscipline(ArrayList<Teacher> teachers, String discipline)
    {
        List<Teacher> stream = teachers.stream()
                .filter(x -> x.disciplines.contains(discipline))
                .collect(Collectors.toList());
        return  new ArrayList<>(stream);
    }
    public static ArrayList<Teacher> getWomenDocent(ArrayList<Teacher> teachers)
    {
        List<Teacher> stream = teachers.stream()
                .filter(x -> x.sex.equals("female")
                && x.position.equals("Docent"))
                .collect(Collectors.toList());
        return  new ArrayList<>(stream);
    }

    public static void searchByDepartment(ArrayList<Teacher> teachers, InputService inputService)
    {
        String department = " ";
        try
        {
            department = inputService.getProperStringInput("department to search");
        }
        catch (InvalidInputException e)
        {
            System.out.println(e.message);
        }
        System.out.println(getByDepartment(teachers, department));
    }
    public static void searchByDiscipline(ArrayList<Teacher> teachers, InputService inputService)
    {
        String discipline = " ";
        try
        {
            discipline = inputService.getProperStringInput("discipline to search");
        }
        catch (InvalidInputException e)
        {
            System.out.println(e.message);
        }
        System.out.println(getByDiscipline(teachers, discipline));
    }

    public static void main(String[] args)
    {
        InputService inputService = new InputService();

        ArrayList<Teacher> teachers = InitTeachers();
        System.out.println("===========Search by department=============");
        searchByDepartment(teachers, inputService);
        System.out.println("===========Search by discipline=============");
        searchByDiscipline(teachers, inputService);
        System.out.println("===========Search women docent =============");
        System.out.println(getWomenDocent(teachers));
        System.out.println("===========All teachers =============");
        System.out.println(teachers);
    }
}
