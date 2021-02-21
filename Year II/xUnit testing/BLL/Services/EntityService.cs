using System;
using System.Collections.Generic;
using System.Linq;
using DAL;


namespace BLL
{
    public class EntityService<T> where T : Entity
    {
        static public void Add(IDataReadWrite<T> dataReadWrite, string instance, string[] data)
        {
            EntityFactory factory = new EntityFactory();
            List<T> entities = new List<T>();
            try
            {
                T[] read = dataReadWrite.ReadData();
                entities = read.ToList();
            }
            catch
            {
                Console.WriteLine("Current file is empty, creating a new one\n");
            }
            if (entities.Equals(null))
            {
                entities = new List<T>();
            }
            entities.Add((T)(object)factory.CreateInstance(instance, data));
            dataReadWrite.WriteData(entities.ToArray());
        }

        static public void Print(IDataReadWrite<T> dataReadWrite)
        {
            List<T> entities = new List<T>();
            try
            {
                T[] read = dataReadWrite.ReadData();
                foreach (T e in read)
                {
                    Console.WriteLine(e.ToString());
                }
            }
            catch
            {
                Console.WriteLine("Current file is empty, add new students\n");
            }
        }

        static public void Delete(IDataReadWrite<T> dataReadWrite, string fName, string sName)
        {
            List<T> entities = new List<T>();
            try
            {
                T[] read = dataReadWrite.ReadData();
                entities = read.ToList<T>();

                T entity = entities.Find(x => x._firstName.Equals(fName) && x._secondName.Equals(sName));
                if (entity != null)
                {
                    entities.Remove(entity);
                }
            }
            catch
            {
                Console.WriteLine("Current file is empty, add new students\n");
            }
        }
        #region student
        static public void SearchTask(IDataReadWrite<Student> dataReadWrite)
        {
            try
            {
                Student[] read = dataReadWrite.ReadData();
                var selected = from s in read
                               where s._course.Equals("2") && s._sex.Equals("male", StringComparison.OrdinalIgnoreCase)
                && float.Parse(s._GPA) > 85.0
                               select s;
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
    }
}
