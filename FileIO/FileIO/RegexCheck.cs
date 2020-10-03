using System;
using System.Text.RegularExpressions;

namespace FileIO
{
    class RegexCheck
    {
        private string nameRegex = @"^[A-Z]{1}[a-z]+$";
        private string sexRegex = @"^[A-Za-z]{4,6}$";

        public Entity AddEntity(string entity)
        {
            if (entity.Equals("student", StringComparison.OrdinalIgnoreCase))
            {
                return AddStudent();
            }
            else if (entity.Equals("doctor", StringComparison.OrdinalIgnoreCase))
            {
                return AddDoctor();
            }
            else return AddMechanic();
        }

        private string GetCorrectRegex(string regex)
        {
            while (true)
            {
                string toCheck = Console.ReadLine();
                if (Regex.IsMatch(toCheck, regex))
                {
                    return toCheck;
                }
                else
                {
                    Console.WriteLine("Enter legit value.\n");
                }
            }
        }

        private Entity AddStudent()
        {
            string courseRegex = @"[1-5]";
            string IDRegex = @"^[A-Z]{2}\d{6}$";
            string GPARegex = @"\d{2}.\d";
            string creditBookRegex = @"\d{6}";
            string[] dataString = new string[7];
            Console.WriteLine("First name:");
            dataString[0] = GetCorrectRegex(nameRegex);
            Console.WriteLine("Second name:");
            dataString[1] = GetCorrectRegex(nameRegex);
            Console.WriteLine("Course: ");
            dataString[2] = GetCorrectRegex(courseRegex);
            Console.WriteLine("StudentID: ");
            dataString[3] = GetCorrectRegex(IDRegex);
            Console.WriteLine("Sex:");
            dataString[4] = GetCorrectRegex(sexRegex);
            Console.WriteLine("GPA:");
            dataString[5] = GetCorrectRegex(GPARegex);
            Console.WriteLine("Credit book ID: ");
            dataString[6] = GetCorrectRegex(creditBookRegex);
            return new Student(dataString);
        }

        private Entity AddMechanic()
        {
            string transportRegex = @"[A-Za-z]*";
            string educationRegex = @"[A-Za-z]*";
            string[] dataString = new string[4];
            Console.WriteLine("First name:");
            dataString[0] = GetCorrectRegex(nameRegex);
            Console.WriteLine("Second name:");
            dataString[1] = GetCorrectRegex(nameRegex);
            Console.WriteLine("Type of repaired transport:");
            dataString[2] = GetCorrectRegex(transportRegex);
            Console.WriteLine("Received education: ");
            dataString[3] = GetCorrectRegex(educationRegex);
            return new Mechanic(dataString);
        }

        private Entity AddDoctor()
        {
            string fieldMedRegex = @"[A-Za-z]*";
            string yearsRegex = @"\d\d?";
            string[] dataString = new string[4];
            Console.WriteLine("First name:");
            dataString[0] = GetCorrectRegex(nameRegex);
            Console.WriteLine("Second name:");
            dataString[1] = GetCorrectRegex(nameRegex);
            Console.WriteLine("Field of medicine: ");
            dataString[2] = GetCorrectRegex(fieldMedRegex);
            Console.WriteLine("Years of experience: ");
            dataString[3] = GetCorrectRegex(yearsRegex);
            return new Doctor(dataString);
        }
    }
}
