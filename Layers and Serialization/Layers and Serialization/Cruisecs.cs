using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Runtime.Serialization;
using System.Security.Permissions;
using System.Text;

namespace Layers_and_Serialization
{
    [Serializable]
    class Cruise : ISerializable
    {
        private int _cruiseNumber;
        private DateTime _date;
        private string _dispatch;
        private string _destination;
        private string _departureTime;
        private string _arrivalTime;

        public Cruise(int cruiseNumber, DateTime date, string dispatch, string destination,
            string departureTime, string arrivalTime)
        {
            _cruiseNumber = cruiseNumber;
            _date = date;
            _dispatch = dispatch;
            _destination = destination;
            _departureTime = departureTime;
            _arrivalTime = arrivalTime;
        }
        protected Cruise(SerializationInfo info, StreamingContext context)
        {
            _cruiseNumber = info.GetInt32("cruise");
            _date = info.GetDateTime("date");
            _dispatch = info.GetString("dispatch");
            _destination = info.GetString("destination");
            _departureTime = info.GetString("departure");
            _arrivalTime = info.GetString("arrival");
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
                $"Cruise was {CruiseTime()} long and ended {TimeSinceCruise()} ago.";
        }

        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        public virtual void GetObjectData(SerializationInfo info, StreamingContext context)
        {
            info.AddValue("cruise", _cruiseNumber);
            info.AddValue("date", _date);
            info.AddValue("dispatch", _dispatch);
            info.AddValue("destination", _destination);
            info.AddValue("departure", _departureTime);
            info.AddValue("arrival", _arrivalTime);
        }
    }
}
