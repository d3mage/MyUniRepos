using System;
using Xunit;
using BLL;
using DAL;
using Provider;
using System.IO;

namespace BLL.Tests
{
    public class UnitTest1
    {
        private void ConfigureStudent()
        {

        }

        [Fact]
        public void Add_AddingStudentSuccessfull()
        {
            string connString = "testData.txt";
            File.Delete(connString);
            
            IDataContext<Student> studentContext = new EntityContext<Student>(connString);
            studentContext.DataProvider = new XMLDataProvider<Student>();
            IDataReadWrite<Student> tempReadWrite = new ReadWriteService<Student>(studentContext);

            string[] dataArray = { "Mike", "Wikers", "3", "IP293581", "male", "86.2", "123598" };


            EntityService<Student>.Add(tempReadWrite, dataArray);

            Student[] students = tempReadWrite.ReadData();
            Assert.True(students.Length > 0); 
        }
    }
}
