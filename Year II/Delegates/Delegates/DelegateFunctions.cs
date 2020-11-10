using System;
using System.Collections.Generic;
using System.Text;

namespace Delegates
{
    class DelegateFunctions
    {
        public void OnExcededMileage(object sender, CarEventArgs e)
        {
            Car car = (Car)sender;
            car.isBroken = true; 
            Console.WriteLine(e.msg);
        }
        public void OnOutOfFuel(object sender, CarEventArgs e)
        {
            Console.WriteLine(e.msg);
        }
    }
}
