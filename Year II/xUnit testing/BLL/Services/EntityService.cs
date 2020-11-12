using System;
using System.Collections.Generic;
using System.Linq;
using DAL;
using Provider;

namespace BLL
{
   public class EntityService<T> 
    {
        static public void Add(IDataReadWrite<T> dataReadWrite, string[] data)
        {
            EntityFactory factory = new EntityFactory();
            List<T> entities = new List<T>();
            try
            {
                T[] read = dataReadWrite.ReadData();
                try
                {
                    entities = read.ToList();
                }
                catch
                {
                    Console.WriteLine("Can't parse entities to list");
                }
            }
            catch
            {
                Console.WriteLine("Current file is empty, creating a new one\n");
            }
            if (entities.Equals(null))
            {
                entities = new List<T>();
            }
            entities.Add((T)(object)factory.CreateInstance("student", data));
            dataReadWrite.WriteData(entities.ToArray());
        }

        static public void Print(IDataReadWrite<T> dataReadWrite)
        {

        }
        #region student
        static public void PrintStudent(IDataReadWrite<Student> dataReadWrite)
        {
            try
            {
                Student[] read = dataReadWrite.ReadData();
                foreach (Student student in read)
                {
                    Console.WriteLine(student.ToString());
                }
            }
            catch
            {
                Console.WriteLine("Current file is empty, add new students\n");
            }
        }
        static public void DeleteStudentByName(IDataReadWrite<Student> dataReadWrite, string fName, string sName)
        {
            List<Student> students = new List<Student>();
            try
            {
                Student[] read = dataReadWrite.ReadData();
                students = read.ToList<Student>();
                foreach(Student s in students)
                {
                    if(s._firstName.Equals(fName, StringComparison.OrdinalIgnoreCase) && s._secondName.Equals(sName, StringComparison.OrdinalIgnoreCase))
                    {
                        students.Remove(s);
                    }
                }
            }
            catch
            {
                Console.WriteLine("Current file is empty, add new students\n");
            }

        }
        static public void SearchTask(IDataReadWrite<Student> dataReadWrite)
        {
            try
            {
                Student[] read = dataReadWrite.ReadData();
                var selected = from s in read
                               where s._course.Equals("2") && s._sex.Equals("male", StringComparison.OrdinalIgnoreCase)
                && float.Parse(s._GPA) > 85.0 select s;  
                foreach (var s in selected)
                {
                    Console.WriteLine(s.ToString());
                }    
            }
            catch
            {
                Console.WriteLine("Current file is empty, add new students\n");
            }
        }
        #endregion

        #region doctor
        static public void DeleteDoctorByName(IDataReadWrite<Doctor> dataReadWrite, string fName, string sName)
        {
            List<Doctor> doctors = new List<Doctor>();
            try
            {
                Doctor[] read = dataReadWrite.ReadData();
                doctors = read.ToList<Doctor>();
                foreach (Doctor s in doctors)
                {
                    if (s._firstName.Equals(fName, StringComparison.OrdinalIgnoreCase) && s._secondName.Equals(sName, StringComparison.OrdinalIgnoreCase))
                    {
                        doctors.Remove(s);
                    }
                }
            }
            catch
            {
                Console.WriteLine("Current file is empty, add new students\n");
            }
        }
        static public void PrintDoctor(IDataReadWrite<Doctor> dataReadWrite)
        {
            try
            {
                Doctor[] read = dataReadWrite.ReadData();
                foreach (Doctor student in read)
                {
                    Console.WriteLine(student.ToString());
                }
            }
            catch
            {
                Console.WriteLine("Current file is empty, add new students\n");
            }
        }
        #endregion

        #region mechanic
        static public void DeleteMechanicByName(IDataReadWrite<Mechanic> dataReadWrite, string fName, string sName)
        {
            List<Mechanic> mechanics = new List<Mechanic>();
            try
            {
                Mechanic[] read = dataReadWrite.ReadData();
                mechanics = read.ToList<Mechanic>();
                foreach (Mechanic s in mechanics)
                {
                    if (s._firstName.Equals(fName, StringComparison.OrdinalIgnoreCase) && s._secondName.Equals(sName, StringComparison.OrdinalIgnoreCase))
                    {
                        mechanics.Remove(s);
                    }
                }
            }
            catch
            {
                Console.WriteLine("Current file is empty, add new students\n");
            }
        }
        static public void PrintMechanic(IDataReadWrite<Mechanic> dataReadWrite)
        {
            try
            {
                Mechanic[] read = dataReadWrite.ReadData();
                foreach (Mechanic student in read)
                {
                    Console.WriteLine(student.ToString());
                }
            }
            catch
            {
                Console.WriteLine("Current file is empty, add new students\n");
            }
        }
        #endregion

    }
}
