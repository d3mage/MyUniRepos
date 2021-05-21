package com.company;

import com.company.SemaphoreReadWrite.SemaphoreRead;
import com.company.SemaphoreReadWrite.SemaphoreWrite;
import com.company.SynchronizedReadWrite.ReadWrite;
import com.company.SynchronizedReadWrite.Reader;
import com.company.SynchronizedReadWrite.Writer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.Semaphore;

public class Menu
{
    private ArrayList<Teacher> teachers;

    String fileName = "file.txt";

    List<Method> menuFunctions;
    MenuFunctions FUNC = new MenuFunctions();

    ReadWrite<Teacher> readWrite;
    Semaphore semaphore = new Semaphore(1, true);


    public void run()
    {
        menuFunctions = getMenuFunctions();
        if (teachers == null) {teachers =  getTeacherList();}
        printMenu();
    }

    private void printMenu()
    {

        boolean exit = false;

        while(exit != true)
        {
            System.out.println("Main menu");
            System.out.println("Name of file: " + fileName);
            System.out.println("What do you want to do? ");
            System.out.println("1. Add new teacher");
            System.out.println("2. Show teachers from file");
            System.out.println("3. Change file name");
            System.out.println("4. Exit");
            int flag = Integer.parseInt(Objects.requireNonNull(input.getInput("menu number", "\\d")));
            if(flag < 1 || flag > 4) {System.out.println("Invalid number");}
            if(flag == 4)
            {
                exit = true;
                break;
            }
            try
            {
                menuFunctions.get(flag - 1).invoke(FUNC);
            } catch (IllegalAccessException | InvocationTargetException e)
            {
                e.printStackTrace();
            }
        }
    }

    private ArrayList<Teacher> getTeacherList()
    {
        ArrayList<Teacher> teachers = new ArrayList<>();

        teachers.add(new Teacher("Dmytro", "Sotnyk", "Sergiyovych", "male",
                new ArrayList<>(Arrays.asList("Coding", "IT")), "FKKPI", "Docent"));
        teachers.add(new Teacher("Liudmyla", "Rybak", "Mykolaivna", "female",
                new ArrayList<>(Arrays.asList("Math", "Cooking")), "FKKPI", "Professor"));
        return teachers;
    }

    public static class input
    {
        public static String getInput(String inputName, String regex)
        {
            Scanner scanner = new Scanner(System.in);

            String input;
            System.out.println("Enter " + inputName);
            for(int i = 0; i < 3; ++i)
            {
                 input = scanner.next(regex);
                 if(input != null) return input;
            }
            return null;
        }
    }

    private ArrayList<Method> getMenuFunctions()
    {
        ArrayList<Method> methods = new ArrayList<>();
        try
        {
            Class<?> c = Class.forName("com.company.Menu$MenuFunctions");
            Method method = c.getDeclaredMethod("addNewTeacher");
            methods.add(method);
            method = c.getDeclaredMethod("readTeachers");
            methods.add(method);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return methods;
    }

    public class MenuFunctions
    {
        private void readSynchro()
        {
            readWrite = new ReadWrite<>();
            Reader<Teacher> reader = new Reader<>(teachers, readWrite, fileName);
            reader.start();
            try {
                reader.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void writeSynchro()
        {
            readWrite = new ReadWrite<>();
            Writer<Teacher> writer = new Writer<>(teachers, readWrite, fileName);
            writer.start();
            try {
                writer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void writeSemaphore()
        {
            SemaphoreWrite<Teacher> semaphoreWrite = new SemaphoreWrite<>(teachers, semaphore, fileName);
            semaphoreWrite.start();
            try {
                semaphoreWrite.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void readSemaphore()
        {
            SemaphoreRead<Teacher> semaphoreRead = new SemaphoreRead<>(teachers, semaphore, fileName);
            semaphoreRead.start();
            try {
                semaphoreRead.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public void addNewTeacher()
        {
            String name = input.getInput("name", "[A-Z][a-z]{2,8}");
            String surname = input.getInput("surname", "[A-Z][a-z]{2,8}");
            String paternal = input.getInput("paternal", "[A-Z][a-z]{5,12}");
            String sex = input.getInput("sex", "([Mm]ale)|([Ff]emale)");
            ArrayList<String> disciplines = new ArrayList<>();
            String discipline = input.getInput("discipline", "[A-Za-z]+");
            disciplines.add(discipline);
            discipline = input.getInput("discipline", "[A-Za-z]+");
            disciplines.add(discipline);
            String cathedra = input.getInput("cathedra", "[A-Za-z]+");
            String chair = input.getInput("chair", "[A-Za-z]+");

            teachers.add(new Teacher(name, surname, paternal, sex, disciplines, cathedra, chair));

            Random random = new Random();
            if(random.nextBoolean())
            {
                writeSynchro();
            }
            else writeSemaphore();
        }

        public void readTeachers()
        {
            Random random = new Random();
            if(random.nextBoolean())
            {
                readSynchro();
            }
            else readSemaphore();
            System.out.println(teachers);
        }
        public void changeFileName()
        {
            fileName = input.getInput("new file name", "[A-Za-z]+.txt");
        }
    }
}
