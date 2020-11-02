using System;
using BLL;
using DAL; 

namespace PL
{
    public class Menu
    {
        private IDataReadWrite<Student> _dataReadWrite;
        private FileConfigurationService<Student> configurationService;
        private FileNameGenerator nameGenerator;
        private string name { get; set; }
        private string extension { get; set; }
        private string mainMenu;
        public Menu()
        {
            configurationService = new FileConfigurationService<Student>();
            nameGenerator = new FileNameGenerator();
            name = "data";
            extension = "txt";
            _dataReadWrite = configurationService.ConfigureFileService(name, extension, nameGenerator);
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
                    if(AskUser("new file name?").Equals("yes", StringComparison.OrdinalIgnoreCase))
                    {
                        name = AskUser("name");
                        extension = AskUser("extension");
                        configurationService.ConfigureFileService(name, extension, nameGenerator);
                    }
                    EntityService<Student>.Add(_dataReadWrite);

                }
                else if (func.Equals("remove", StringComparison.OrdinalIgnoreCase))
                {
                    Console.Clear();

                }
                else if (func.Equals("see", StringComparison.OrdinalIgnoreCase))
                {
                    Console.Clear();

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
            "Add entity\nRemove entity\n";
        }
        private string AskUser(string ToDo)
        {
            Console.WriteLine($"Select {ToDo}");
            return Console.ReadLine();
        }
        
    }
}
