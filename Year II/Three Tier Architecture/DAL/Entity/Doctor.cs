using System;
using System.Collections.Generic;
using System.Text;

namespace DAL
{
    [Serializable]
    public class Doctor : Entity
    {
        public string _medicineField { get; set; }
        public string _yearsOfExp { get; set; }
        [NonSerialized] public IComposeStory story;
        public void SetStory(IComposeStory cs)
        {
            story = cs;
        }
        public Doctor()
        {

        }
        public Doctor(string[] source)
        {
            _firstName = source[0];
            _secondName = source[1];
            _medicineField = source[2];
            _yearsOfExp = source[3];
            SetStory(new DoctorStory());
        }

        public Doctor(Doctor doctor)
        {
            _firstName = doctor._firstName;
            _secondName = doctor._secondName;
            _medicineField = doctor._medicineField;
            _yearsOfExp = doctor._yearsOfExp;
        }

        public override string ToString()
        {
            return $"Student: {_firstName}{_secondName}\n" +
                $"firstName: {_firstName}\n" +
                $"secondName: {_secondName}\n" +
                   $"medicineField: {_medicineField}" +
                   $"yearsOfExp: {_yearsOfExp}";
        }
    }
}
