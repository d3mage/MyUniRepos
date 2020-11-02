using System;
using System.Collections.Generic;
using System.Text;

namespace DAL
{
    [Serializable]
    public class Mechanic : Entity
    {
        private string _typeOfTransport;
        private string _education;
        [NonSerialized] public IComposeStory story;
        public void SetStory(IComposeStory cs)
        {
            story = cs;
        }
        public Mechanic()
        {

        }
        public Mechanic(string[] source)
        {
            _firstName = source[0];
            _secondName = source[1];
            _typeOfTransport = source[2];
            _education = source[3];
            SetStory(new MechanicStory());
        }
        public Mechanic(Mechanic mechanic)
        {
            _firstName = mechanic._firstName;
            _secondName = mechanic._secondName;
            _typeOfTransport = mechanic._typeOfTransport;
            _education = mechanic._education;
        }

        public override string ToString()
        {
            return $"Student: {_firstName}{_secondName}\n" +
                 $"firstName: {_firstName}\n" +
                 $"secondName: {_secondName}\n" +
                 $"typeOfTransport: {_typeOfTransport}" +
                $"edcation: {_education}";
        }
    }
}
