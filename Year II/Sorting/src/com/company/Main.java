package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main
{
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
        int room;

        ArrayList<Student> students = new ArrayList<>();
        for(int i = 0; i < 5; ++i)
        {
            surname = surnames.get(random.nextInt(surnames.size()));
            name = names.get(random.nextInt(names.size()));
            room = random.nextInt(300);
            students.add(new Student(surname, name, room));
        }
        return students;
    }
    
    public static void ShakerSort(ArrayList<Student> students)
    {
        int size = students.size();
        int left = 1;
        int right = size-1;

        while (left <= right)
        {
            for(int i = left; i <= right; i++)
            {
                if(students.get(i-1).room > students.get(i).room )
                {
                    Student temp = students.get(i);
                    students.set(i, students.get(i - 1 ));
                    students.set(i-1, temp);
                }
            }
            right--;
            for(int i = right; i >= left; i--)
            {
                if (students.get(i-1).room > students.get(i).room)
                {
                    Student temp = students.get(i);
                    students.set(i, students.get(i - 1 ));
                    students.set(i-1, temp);
                }
            }
            left++;
        }
        System.out.println(students);
    }

    private static <T> void Swap(T[] array, int fIndex, int sIndex)
    {
        T temp = array[fIndex];
        array[fIndex] = array[sIndex];
        array[sIndex] = temp;
    }

    public static void ArrayShakerSort(Student[] students)
    {
        int size = students.length;
        int left = 1;
        int right = size-1;

        while (left <= right)
        {
            for(int i = left; i <= right; i++)
            {
                if(students[i-1].room > students[i].room)
                {
                    Swap(students, i, i-1);
                }
                else if (students[i - 1].room.equals(students[i].room))
                {
                    int j = i;
                    while (j > 0 && students[j - 1].room.equals(students[i].room))
                    {
                        if(students[j-1].lastName.compareTo(students[j].lastName) == 1)
                        {
                            Swap(students, j, j-1);
                        }
                        j--;
                    }
                }
            }
            right--;
            for(int i = right; i >= left; i--)
            {
                if (students[i - 1].room > students[i].room)
                {
                    Swap(students, i, i-1);
                }
                else if(students[i - 1].room.equals(students[i].room))
                {
                    int j = i;
                    while (j > 0 && students[j - 1].room.equals(students[i].room))
                    {
                        if(students[j-1].lastName.compareTo(students[j].lastName) == 1)
                        {
                            Swap(students, j, j-1);
                        }
                        j--;
                    }
                }
            }
            left++;
        }
        System.out.println(Arrays.toString(students));
    }

    public static void heapSort(Student[] students)
    {
        int size = students.length;

        for (int i = size / 2 - 1; i >= 0; --i)
        {
            makeHeap(students, size, i);
        }

        for (int i = size - 1; i >= 0; --i)
        {
            Swap(students, 0, i);
            makeHeap(students, i, 0);
        }
        System.out.println(Arrays.toString(students));
    }

    private static void makeHeap(Student[] students, int size, int i)
    {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && students[left].room > students[largest].room)
        {
            largest = left;
        }
        else if (right < size && students[right].room > students[largest].room)
        {
            largest = right;
        }

        if (largest != i)
        {
            Swap(students, i, largest);
            makeHeap(students, size, largest);
        }
    }

    public static void main(String[] args)
    {
        ArrayList<Student> students = initStudents();
        Student[] students1 = students.toArray(new Student[0]);
        System.out.println(students);
        ShakerSort(students);
        ArrayShakerSort(students1);
        heapSort(students1);
    }
}
