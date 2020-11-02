using System;
using System.Collections.Generic;
using DAL;
using Provider;

namespace BLL
{
   public class EntityService<T> 
    {
        static public void Add(IDataReadWrite<T> dataReadWrite)
        {
            EntityFactory factory = new EntityFactory();
            
            IDataContext<Student> context = new EntityContext<Student>("data.txt");
            context.DataProvider = new XMLDataProvider<Student>();
            IDataReadWrite<Student> myDataReadWrite = new ReadWriteService<Student>(context);
            //myDataReadWrite.WriteData(students);
            Student[] read = myDataReadWrite.ReadData(); 
            foreach(Student s in read)
            {
                Console.WriteLine(s.ToString());
            }
            //dataReadWrite.WriteData(students); 
        }
    }
}
