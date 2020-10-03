using System;

namespace FileIO
{
    class ConsoleMenu
    {
        Data data;

        public ConsoleMenu()
        {
            data = new Data();
            PrintMenu();
        }

        public void PrintMenu()
        {
            string consoleText = "Main menu\n" +
                "What do you want to do?\n" +
                "Add new person\nSee info\nProcess student data" +
                "\nExit";
            bool exit = false;

            while (exit != true)
            {
                Console.WriteLine(consoleText);
                string func = Console.ReadLine();
                if (func.Equals("add", StringComparison.OrdinalIgnoreCase))
                {
                    Console.Clear();
                    data.AddToDB();
                }
                else if (func.Equals("process", StringComparison.OrdinalIgnoreCase))
                {
                    Console.Clear();
                    data.CalculateStudents();
                }
                else if (func.Equals("see", StringComparison.OrdinalIgnoreCase))
                {
                    Console.Clear();
                    data.PrintDB();
                }
                else if (func.Equals("exit", StringComparison.OrdinalIgnoreCase))
                {
                    data.WriteToStorage();
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
    }
}
