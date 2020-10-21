using System;
using System.IO;


namespace FileIO
{
    class Data
    {
        private string path = Environment.GetFolderPath(Environment.SpecialFolder.Desktop) + @"\Text.txt";

        public string dataString;
        public object[] elementsDB = new object[0];

        RegexCheck regex;

        public Data()
        {
            InitializeDBArray();
            regex = new RegexCheck();
        }

        private void InitializeDBArray()
        {
            ReadWrite.ReadWrite.Read(path, out dataString);
            StringReader sr = new StringReader(dataString);
            string currentLine = null;
            while (true)
            {
                currentLine = sr.ReadLine();
                if (currentLine != null)
                {
                    string[] value = currentLine.Split(": ");
                    if (value[0].Equals("student", StringComparison.OrdinalIgnoreCase))
                    {
                        AddEntityToDB(StudentToArray(ref sr));
                    }
                    else if(value[0].Equals("doctor", StringComparison.OrdinalIgnoreCase))
                    {
                        AddEntityToDB(DoctorToArray(ref sr));
                    }
                    else if (value[0].Equals("mechanic", StringComparison.OrdinalIgnoreCase))
                    {
                        AddEntityToDB(MechanicToArray(ref sr));
                    }
                }
                else break;
            }
        }
        private void AddEntityToDB(Entity entity)
        {
            Array.Resize<object>(ref elementsDB, elementsDB.Length + 1);
            elementsDB[elementsDB.Length - 1] = entity;
        }
        private Entity StudentToArray(ref StringReader sr)
        {
            return new Student(ConstructorDataArray(7, ref sr));
        }
        private Entity DoctorToArray(ref StringReader sr)
        {
            return new Doctor(ConstructorDataArray(4, ref sr));
        }
        private Entity MechanicToArray(ref StringReader sr)
        {
            return new Mechanic(ConstructorDataArray(4, ref sr));
        }
        private string[] ConstructorDataArray(int size, ref StringReader sr)
        {
            string[] toCreate = new string[size];
            for (int i = 0; i < toCreate.Length; ++i)
            {
                string currentLine = sr.ReadLine();
                string[] value = currentLine.Split(": ");
                toCreate[i] = value[1];
            }
            return toCreate;
        }

        public void AddToDB()
        {
            Entity person;
            Console.WriteLine("What's person's job?");
            string job = Console.ReadLine();
            if (job.Equals("student", StringComparison.OrdinalIgnoreCase))
            {
                person = regex.AddEntity("student");
                AddEntityToDB(person);
            }
            else if (job.Equals("doctor", StringComparison.OrdinalIgnoreCase))
            {
                person = regex.AddEntity("doctor");
                AddEntityToDB(person);
            }
            else
            {
                person = regex.AddEntity("mechanic");
                AddEntityToDB(person);
            }
        }

        public void CalculateStudents()
        {
            Student currStudent;
            foreach (var obj in elementsDB)
            {
                if (obj is Student)
                {
                    currStudent = new Student((Student)obj);
                    if (currStudent.Course.Equals("2", StringComparison.OrdinalIgnoreCase) &&
                        double.Parse(currStudent.GPA) > 75 && currStudent.Sex.Equals("male", StringComparison.OrdinalIgnoreCase))
                    {
                        Console.WriteLine(currStudent.ToString());
                    }
                }
            }
        }

        public void PrintDB()
        {
            foreach (var obj in elementsDB)
            {
                Console.WriteLine(obj.ToString());
            }
        }

        public void WriteToStorage()
        {
            ReadWrite.ReadWrite.Flush(path);
            foreach (var obj in elementsDB)
            {
                ReadWrite.ReadWrite.Write(path, obj.ToString());
            }
        }
    }
}

