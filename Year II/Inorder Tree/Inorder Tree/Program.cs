using System;
using System.Collections;
using System.Collections.Generic;

namespace Inorder_Tree
{
    class Program
    {
        static void Main(string[] args)
        {
            DateTime firstDate = new DateTime(2020, 10, 6, 0, 0, 0);
            DateTime secondDate = new DateTime(2020, 10, 12, 0, 0, 0);
            TimeSpan fDeparture = new TimeSpan(4, 30, 0);
            TimeSpan fArrival = new TimeSpan(6, 45, 0);
            TimeSpan sDeparture = new TimeSpan(20, 10, 0);
            TimeSpan sArrival = new TimeSpan(21, 15, 0);
            Cruise _cruise1 = new Cruise(5890, firstDate, "Kyiv", "Munich", fDeparture, fArrival);
            Cruise _cruise2 = new Cruise(0599, firstDate, "Kyiv", "NY", fDeparture, sArrival);
            Cruise _cruise3 = new Cruise(3293, secondDate, "Kharkiv", "Krakow", sDeparture, sArrival);
            Cruise _cruise4 = new Cruise(1932, secondDate, "Kyiv", "Hong Kong", sDeparture, fArrival);
            Cruise _cruise5 = new Cruise(4390, firstDate, "Kharkiv", "Kyiv", sDeparture, sArrival); 

            Cruise[] cruises1 = new Cruise[3];
            cruises1[0] = _cruise1;
            cruises1[1] = _cruise2;
            cruises1[2] = _cruise3;
            AddToArray(_cruise4, ref cruises1);
            DeleteFromArray(_cruise1, ref cruises1);
            Console.WriteLine(FindElementPos(_cruise3, cruises1));

            ArrayList cruises2 = new ArrayList();
            cruises2.Add(_cruise1);
            cruises2.Add(_cruise2);
            cruises2.Remove(_cruise2);
            Console.WriteLine(cruises2.Contains(_cruise2));

            List<Cruise> cruises3 = new List<Cruise>();
            cruises3.Add(_cruise1);
            cruises3.Add(_cruise2);
            cruises3.Remove(_cruise2);
            Console.WriteLine(cruises3.Contains(_cruise2));

            BinaryTree<Cruise> tree = new BinaryTree<Cruise>(_cruise3);
            tree.Insert(_cruise1);
            tree.Insert(_cruise2);
            tree.Insert(_cruise4);
            tree.Print();
            tree.isInTree(_cruise5); 
        }

        static void AddToArray(Cruise addable, ref Cruise[] array)
        {
            Array.Resize<Cruise>(ref array, array.Length + 1);
            array[array.Length - 1] = addable; 
        }
        static void DeleteFromArray(Cruise deleteable, ref Cruise[] array)
        {
            Cruise[] toReturn = new Cruise[array.Length - 1];
            int pos = 0;
            foreach(var cruise in array)
            {
                if(!cruise.Equals(deleteable))
                {
                    toReturn[pos++] = cruise; 
                }
            }
            array = toReturn; 
        }
        static int FindElementPos(Cruise findable, Cruise[] array)
        {
            int pos = 0; 
            foreach(var cruise in array)
            {
                if (cruise.Equals(findable))
                {
                    return pos;
                }
                else pos++; 
            }
            return -1;
        }
        static void PrintArray(Cruise[] array)
        {
            foreach(var cruise in array)
            {
                Console.WriteLine(cruise.ToString());
            }
            Console.WriteLine("\n");
        }
    }
}
