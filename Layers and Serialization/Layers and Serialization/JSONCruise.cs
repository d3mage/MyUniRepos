using System;
using System.Collections.Generic;
using System.Runtime.Serialization;
using System.Text;

namespace Layers_and_Serialization
{
    [DataContract]
    class JSONCruise 
    {
        [DataMember]
        public int _cruiseNumber;
        [DataMember]
        public DateTime _date;
        [DataMember]
        public string _dispatch;
        [DataMember]
        public string _destination;
        [DataMember]
        public string _departureTime;
        [DataMember]
        public string _arrivalTime;

        public JSONCruise(int cruiseNumber, DateTime date, string dispatch, string destination,
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
