namespace Delegates
{
    class Car
    {
        public string Name { get; set; }
        public double DistanceTraveled { get; set; }
        public double Speed { get; set; }
        public double FuelAmmount { get; set; }

        public bool isBroken; 

        public delegate void CarHandler(object sender, CarEventArgs args);
        public event CarHandler ExcededMileage;
        public event CarHandler OutOfFuel; 

        DelegateFunctions functions = new DelegateFunctions(); 

        public Car(string name, double traveled, double fuel)
        {
            Name = name;
            DistanceTraveled = traveled;
            Speed = 0; 
            FuelAmmount = fuel;

            isBroken = false; 

            ExcededMileage += functions.OnExcededMileage;
            OutOfFuel += functions.OnOutOfFuel;
        }

        public void StartMoving()
        {
            Speed = 40; 
        }

        public void Travel(int time)
        {
            if(isBroken == false)
            {
                double traveled = time * Speed;
                double fuelSpent = traveled / 100 * 3;
                if (fuelSpent > FuelAmmount)
                {
                    traveled = FuelAmmount / 100 * 3;
                    OutOfFuel?.Invoke(this, new CarEventArgs("Out of fuel, traveled as much as possible"));
                }
                else
                {
                    FuelAmmount -= fuelSpent;
                }
                DistanceTraveled += traveled;
                if (DistanceTraveled >= 500)
                {
                    ExcededMileage?.Invoke(this, new CarEventArgs("Traveled way too much, now broken"));
                }
            }
        }

        public void StopMoving()
        {
            Speed = 0; 
        }

       
    }
}
