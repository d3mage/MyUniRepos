using System;
using System.Collections.Generic;
using System.Text;

namespace Layers_and_Serialization
{
    [Serializable]
    public class XMLCruise
    {
        public int _cruiseNumber;
        public DateTime _date;
        public string _dispatch;
        public string _destination;
        public string _departureTime;
        public string _arrivalTime;

        public XMLCruise()
        {

        }

        public XMLCruise(int cruiseNumber, DateTime date, string dispatch, string destination,
            string departureTime, string arrivalTime)
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
            return (DateTime.Parse(_departureTime) - DateTime.Parse(_arrivalTime)).Duration().ToString();
        }
        private string TimeSinceCruise()
        {
            return (DateTime.Now - DateTime.Parse(_arrivalTime)).Duration().ToString(@"hh\:mm\:ss");
        }

        public override string ToString()
        {
            return $"{_date.ToString(@"dd/MM/yy")} Cruise #{_cruiseNumber} from {_dispatch} to {_destination}\n" +
                $"Departured: {_departureTime} Arrived: {_arrivalTime}\n" +
                $"Cruise was {CruiseTime()} long and ended {TimeSinceCruise()} ago.\n";
        }
    }
}
