using System;

namespace Inorder_Tree
{
    class Cruise : IComparable
    {
        private int _cruiseNumber;
        private DateTime _date;
        private string _dispatch;
        private string _destination;
        private TimeSpan _departureTime;
        private TimeSpan _arrivalTime; 

        public Cruise(int cruiseNumber, DateTime date, string dispatch, string destination,
            TimeSpan departureTime, TimeSpan arrivalTime)
        {
            _cruiseNumber = cruiseNumber;
            _date = date;
            _dispatch = dispatch;
            _destination = destination;
            _departureTime = departureTime;
            _arrivalTime = arrivalTime; 
        }

        private string CruiseTime()
        {
            TimeSpan diff = _arrivalTime - _departureTime;
            return diff.ToString();
        }
        private string TimeSinceCruise()
        {
            TimeSpan since = DateTime.Now.TimeOfDay - _arrivalTime;
            return since.ToString(@"hh\:mm\:ss");
        }
    
        public override string ToString()
        {
            return $"{_date.ToString(@"dd/MM/yy")} Cruise #{_cruiseNumber} from {_dispatch} to {_destination}\n" +
                $"Departured: {_departureTime} Arrived: {_arrivalTime}\n" +
                $"Cruise was {CruiseTime()} long and ended {TimeSinceCruise()} ago.";
        }

        public int CompareTo(object obj)
        {
            if (obj == null) return -1;
            Cruise otherCruise = obj as Cruise;
            if (otherCruise != null)
            {
                return _cruiseNumber.CompareTo(otherCruise._cruiseNumber);
            }
            else throw new ArgumentException(); 
        }
    }
}
