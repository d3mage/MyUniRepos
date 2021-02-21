using System;
using Xunit;
using BLL;
using DAL;
using Provider;
using System.IO;
using Moq; 

namespace BLL.Tests
{
    public class UnitTest1
    {
        [Fact]
        public void Add_Successfull()
        {
            Student[] students = GetStudents();
            string[] data = new string[] { "Ludmyla", "Rybak", "2", "KB433478", "female", "93.2", "2349122" };

            Student student = new Student(data);

            var readWriteMock = new Mock<IDataReadWrite<Student>>();
            readWriteMock.Setup(x => x.ReadData()).Returns(students);
            readWriteMock.Setup(x => x.WriteData(It.IsAny<Student[]>())).Verifiable(); 

            var factoryMock = new Mock<IEntityFactory>();
            factoryMock.Setup(x => x.CreateInstance("student", data)).Returns(student);

            EntityService<Student>.Add(readWriteMock.Object, "student", data);

            readWriteMock.Verify(x => x.WriteData(It.IsAny<Student[]>()), Times.Once); 
        }
        [Fact]
        public void Add_ListNull()
        {
            Student[] students = null;
            string[] data = new string[] { "Ludmyla", "Rybak", "2", "KB433478", "female", "93.2", "2349122" };

            Student student = new Student(data);

            var readWriteMock = new Mock<IDataReadWrite<Student>>();
            readWriteMock.Setup(x => x.ReadData()).Returns(students);

            var factoryMock = new Mock<IEntityFactory>();
            factoryMock.Setup(x => x.CreateInstance("student", data)).Returns(student);

            EntityService<Student>.Add(readWriteMock.Object, "student", data);

            readWriteMock.Verify(x => x.WriteData(It.IsAny<Student[]>()), Times.Once);
        }




        public Student[] GetStudents()
        {
            string[] studentData = new string[] { "Dmytro", "Sotnyk", "2", "KB4329878", "male", "90.2", "2349792" };
            Student student = new Student(studentData);
            Student[] students = new Student[] { student };
            return students;
        }
    }
}
