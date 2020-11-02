using System;
using System.Collections.Generic;
using System.IO;
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Runtime.Serialization.Formatters.Binary;
using System.Runtime.Serialization.Json;
using System.Xml.Serialization;
using System.Runtime.Serialization;

namespace Layers_and_Serialization
{
    class Program
    {
        static void Main(string[] args)
        {
            DateTime dateTime = new DateTime(2020, 4, 26, 8, 19, 0);
            DateTime dateTime1 = new DateTime(2020, 6, 27, 19, 2, 0);
            #region BinaryFormatter
            Cruise cruise = new Cruise(2349, dateTime, "Kyiv", "London", "8:21:00", "12:39:00");
            Cruise cruise1 = new Cruise(5301, dateTime1, "Kyiv", "Lyon", "19:29:00", "1:08:00");
            Cruise[] sourceArray = new Cruise[] { cruise, cruise1 };
            Cruise[] destArray;

            List<Cruise> sourceList = new List<Cruise>();
            sourceList.Add(cruise);
            sourceList.Add(cruise1);
            List<Cruise> destList;

            BinaryFormatter binaryFormatter = new BinaryFormatter();
            using(FileStream fs = new FileStream("cruise.txt", FileMode.OpenOrCreate))
            {
                binaryFormatter.Serialize(fs, sourceArray);
            }
            using(FileStream fs = new FileStream("cruise.txt", FileMode.OpenOrCreate))
            {
                destArray = (Cruise[])binaryFormatter.Deserialize(fs);
            }
            foreach(Cruise c in destArray)
            {
                Console.WriteLine(c.ToString());
            }    
 
            using(FileStream fs = new FileStream("binary.dat", FileMode.OpenOrCreate))
            {
                binaryFormatter.Serialize(fs, sourceList); 
            }
            using (FileStream fs = new FileStream("binary.dat", FileMode.OpenOrCreate))
            {
               destList = (List<Cruise>)binaryFormatter.Deserialize(fs);
            }
            foreach (Cruise c in destList)
            {
                Console.WriteLine(c.ToString());
            }
            #endregion

            #region JSonFormatter
            JSONCruise jsoncruise = new JSONCruise(2349, dateTime, "Kyiv", "London", "8:21:00", "12:39:00");
            JSONCruise jsoncruise1 = new JSONCruise(5301, dateTime1, "Kyiv", "Lyon", "19:29:00", "1:08:00");
            JSONCruise[] jsonsourceArray = new JSONCruise[] { jsoncruise, jsoncruise1 };
            JSONCruise[] jsondestArray;
           
            DataContractJsonSerializer jsonFormatter = new DataContractJsonSerializer(typeof(JSONCruise[]));
            using (FileStream fsjsn = new FileStream("cruise.json", FileMode.OpenOrCreate))
            {
                jsonFormatter.WriteObject(fsjsn, jsonsourceArray);
            }
            using (FileStream fsjsn = new FileStream("cruise.json", FileMode.OpenOrCreate))
            {
               jsondestArray = (JSONCruise[])jsonFormatter.ReadObject(fsjsn);

                foreach (JSONCruise c in jsondestArray)
                {
                    Console.WriteLine(c.ToString());
                }
            }
            #endregion

            #region XMLFormatter
            XMLCruise xmlcruise = new XMLCruise(2349, dateTime, "Kyiv", "London", "8:21:00", "12:39:00");
            XMLCruise xmlcruise1 = new XMLCruise(5301, dateTime1, "Kyiv", "Lyon", "19:29:00", "1:08:00");
            XMLCruise[] xmlsourceArray = new XMLCruise[] { xmlcruise, xmlcruise1 };
            XMLCruise[] xmldestArray;

            XmlSerializer formatter1 = new XmlSerializer(typeof(XMLCruise[]));
            using (FileStream fs = new FileStream("cruise.xml", FileMode.OpenOrCreate))
            {
                formatter1.Serialize(fs, xmlsourceArray);
            }
            using (FileStream fs = new FileStream("cruise.xml", FileMode.OpenOrCreate))
            {
                xmldestArray = (XMLCruise[])formatter1.Deserialize(fs);
            }
            foreach (XMLCruise c in xmldestArray)
            {
                Console.WriteLine(c.ToString());
            }
            #endregion

            #region CustomFormatter
            CustomCruise customcruise = new CustomCruise(2349, dateTime, "Kyiv", "London", "8:21:00", "12:39:00");
            CustomCruise customcruise1 = new CustomCruise(5301, dateTime1, "Kyiv", "Lyon", "19:29:00", "1:08:00");
            CustomCruise[] customsourceArray = new CustomCruise[] { customcruise, customcruise1 };
            CustomCruise[] customdestArray;
            
            IFormatter formatter = new BinaryFormatter();
            using (FileStream fs = new FileStream("cruise.data", FileMode.OpenOrCreate))
            {
                binaryFormatter.Serialize(fs, customsourceArray);
            }
            using (FileStream fs = new FileStream("cruise.data", FileMode.OpenOrCreate))
            {
                customdestArray = (CustomCruise[])binaryFormatter.Deserialize(fs);
            }
            foreach (CustomCruise c in customdestArray)
            {
                Console.WriteLine(c.ToString());
            }

            #endregion
        }
    }
}
