using System;
using System.Data;
using System.Runtime.Serialization;
using BLL;
using DAL; 

namespace PL
{
    public class Menu
    {
        private RegexService regexService; 
        private FileNameGenerator nameGenerator;

        private FileConfigurationService<Student> studentConfigurationService;
        private FileConfigurationService<Doctor> doctorConfigurationService;
        private FileConfigurationService<Mechanic> mechanicConfigurationService; 

        private IDataReadWrite<Student> studentReadWrite;
        private IDataReadWrite<Doctor> doctorReadWrite; 
        private IDataReadWrite<Mechanic> mechanicReadWrite; 

        private string name { get; set; }
        private string extension { get; set; }
        private string mainMenu;
        public Menu()
        {
            regexService = new RegexService(); 
            nameGenerator = new FileNameGenerator();

            studentConfigurationService = new FileConfigurationService<Student>();
            doctorConfigurationService = new FileConfigurationService<Doctor>();
            mechanicConfigurationService = new FileConfigurationService<Mechanic>(); 

            name = "data";
            extension = "txt";
            studentReadWrite = studentConfigurationService.ConfigureFileService(name, extension, "student", nameGenerator);
            doctorReadWrite = doctorConfigurationService.ConfigureFileService(name, extension, "doctor", nameGenerator);
            mechanicReadWrite = mechanicConfigurationService.ConfigureFileService(name, extension, "mechanic", nameGenerator); 

            PrintMenu();
        }

        private void PrintMenu()
        {
            bool exit = false;
            while (exit != true)
            {
                UpdateMenu();
                Console.WriteLine(mainMenu);
                string func = Console.ReadLine();
                if (func.Equals("add", StringComparison.OrdinalIgnoreCase))
                {
                    Console.Clear();
                    Configure();
                    string decision = AskUser("Select enity: student, doctor, mechanic", "[A-Za-z]+");
                    if (decision.Equals("student", StringComparison.OrdinalIgnoreCase))
                    {
                        EntityService<Student>.Add(studentReadWrite, "student", GetDataArray("student"));
                    }
                    else if(decision.Equals("doctor", StringComparison.OrdinalIgnoreCase))
                    {
                        EntityService<Doctor>.Add(doctorReadWrite, "doctor", GetDataArray("doctor"));
                    }
                    else if(decision.Equals("mechanic", StringComparison.OrdinalIgnoreCase))
                    {
                        EntityService<Mechanic>.Add(mechanicReadWrite, "mechanic", GetDataArray("mechanic"));
                    }
                }
                else if (func.Equals("remove", StringComparison.OrdinalIgnoreCase))
                {
                    Console.Clear();
                    string decision = AskUser("Select enity: student, doctor, mechanic", "[A-Za-z]+");
                    if (decision.Equals("student", StringComparison.OrdinalIgnoreCase))
                    {
                        EntityService<Student>.Delete(studentReadWrite, AskUser("Enter name", @"[A-Z]?\w+"), AskUser("Enter name", @"[A-Z]?\w+"));
                    }
                    else if (decision.Equals("doctor", StringComparison.OrdinalIgnoreCase))
                    {
                        EntityService<Doctor>.Delete(doctorReadWrite, AskUser("Enter name", @"[A-Z]?\w+"), AskUser("Enter name", @"[A-Z]?\w+"));
                    }
                    else if (decision.Equals("mechanic", StringComparison.OrdinalIgnoreCase))
                    {
                        EntityService<Mechanic>.Delete(mechanicReadWrite, AskUser("Enter name", @"[A-Z]?\w+"), AskUser("Enter name", @"[A-Z]?\w+"));
                    }
                }
                else if (func.Equals("print", StringComparison.OrdinalIgnoreCase))
                {
                    Console.Clear();
                    string decision = AskUser("Select enity: student, doctor, mechanic", "[A-Za-z]+");
                    if (decision.Equals("student", StringComparison.OrdinalIgnoreCase))
                    {
                        EntityService<Student>.Print(studentReadWrite); 
                    }
                    else if (decision.Equals("doctor", StringComparison.OrdinalIgnoreCase))
                    {
                        EntityService<Doctor>.Print(doctorReadWrite);
                    }
                    else if (decision.Equals("mechanic", StringComparison.OrdinalIgnoreCase))
                    {
                        EntityService<Mechanic>.Print(mechanicReadWrite); 
                    }

                }
                else if (func.Equals("task", StringComparison.OrdinalIgnoreCase))
                {
                    EntityService<Student>.SearchTask(studentReadWrite);
                }
                else if (func.Equals("exit", StringComparison.OrdinalIgnoreCase))
                {
                    exit = true;
                    break;
                }
                else
                {
                    Console.WriteLine();
                    continue;
                }
            }
        }

        private void UpdateMenu()
        {
            mainMenu = $"Current file name: {name}.{extension}\n" +
            "What do you want to do?\n" +
            "Add entity\nPrint available entities\nRemove entity\nTask\nExit";
        }
        private string AskUser(string ToDo, string regex)
        {
            Console.WriteLine($"{ToDo}");
            string decision = Console.ReadLine();
            bool finished = regexService.isCorrectRegex(decision, regex);
            while (finished != true)
            {
                Console.WriteLine("Enter legit value");
                decision = Console.ReadLine(); 
            }
            return decision; 
        }
        private void Configure()
        {
            if (AskUser("Select new file name?", @"[A-Za-z]{1,3}").Equals("yes", StringComparison.OrdinalIgnoreCase))
            {
                name = AskUser("Enter name", @"[A-Z]?\w+");
                extension = AskUser("Enter extension", @"[A-Za-z]{3}");
                studentConfigurationService.ConfigureFileService(name, extension, "student", nameGenerator);
                doctorConfigurationService.ConfigureFileService(name, extension, "doctor", nameGenerator);
                mechanicConfigurationService.ConfigureFileService(name, extension, "mechanic", nameGenerator);
            }
            else return; 
        }
        private string[] GetDataArray(string entity)
        {
            switch (entity)
            {
                case "student":
                    return GetStudentArray();
                case "doctor":
                    return GetDoctorArray();
                case "mechanic":
                    return GetMechanicArray(); 
                default:
                    return GetMechanicArray(); 
            }
        }
        private string[] GetStudentArray()
        {
            string[] dataString = new string[7];
            dataString[0] = AskUser("Enter name: ", @"^[A-Z]?[a-z]+$");
            dataString[1] = AskUser("Enter surname: ", @"^[A-Z]?[a-z]+$");
            dataString[2] = AskUser("Enter course: ", @"[1-5]");
            dataString[3] = AskUser("Enter student ID: ", @"[A-Z]{2}\d{4,}");
            dataString[4] = AskUser("Enter sex: ", @"^[A-Za-z]{4,6}$");
            dataString[5] = AskUser("Enter GPA: ", @"\d?\d.\d");
            dataString[6] = AskUser("Enter credit book ID:", @"\d{6}");
            return dataString; 
        }
        private string[] GetDoctorArray()
        {
            string[] dataString = new string[4];
            dataString[0] = AskUser("Enter name: ", @"^[A-Z]?[a-z]+$");
            dataString[1] = AskUser("Enter surname: ", @"^[A-Z]?[a-z]+$");
            dataString[2] = AskUser("Enter medicine field: ", @"[A-Za-z]{3-10}");
            dataString[3] = AskUser("Enter years of experience: ", @"\d?\d");
            return dataString;
        } 
        private string[] GetMechanicArray()
        {
            string[] dataString = new string[4];
            dataString[0] = AskUser("Enter name: ", @"^[A-Z]?[a-z]+$");
            dataString[1] = AskUser("Enter surname: ", @"^[A-Z]?[a-z]+$");
            dataString[2] = AskUser("Enter type of transport: ", @"[A-Za-z]{3, 15}");
            dataString[3] = AskUser("Enter education: ", @"[A-Za-z]{3, 8}");
            return dataString;
        }
        
    }
}
