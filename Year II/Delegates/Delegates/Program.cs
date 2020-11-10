using System;
using System.Dynamic;

namespace Delegates
{
    class Program
    {
        delegate int StringFunction(string text, char c);

        static void Main(string[] args)
        {
            //#region delegate
            //string text = "seems legit";
            //char c = 'e';
            //StringFunction func = delegate (string text, char c)
            //{
            //    return text.LastIndexOf(c);
            //};
            //Console.WriteLine($"Last letter \'{c}\' in \"{text}\" is in position {func(text, c)}");
            //func = (text, c) => text.LastIndexOf(c);
            //Console.WriteLine($"Last letter \'{c}\' in \"{text}\" is in position {func(text, c)}");
            //#endregion

            #region car
            Car car = new Car("niggersan", 300, 150);
            car.StartMoving();
            car.Travel(5);
            car.StopMoving(); 
            #endregion
        }
    }
}
