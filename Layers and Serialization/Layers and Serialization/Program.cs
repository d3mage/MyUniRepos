using System;
using System.IO;
using System.Runtime.InteropServices;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;

namespace Layers_and_Serialization
{
    class Program
    {
        static void Main(string[] args)
        {
            DateTime dateTime = new DateTime(2020, 4, 26, 8, 19, 0);
            Cruise cruise = new Cruise(2349, dateTime, "Kyiv", "London", "8:21:00", "12:39:00");
            IFormatter formatter = new BinaryFormatter();
            Stream stream = new FileStream("MyFile.txt", FileMode.Open, FileAccess.Read, FileShare.Read);
            Cruise cruise1 = (Cruise)formatter.Deserialize(stream); 
            stream.Close();

            Console.WriteLine(cruise1.ToString());
        }
    }
}
