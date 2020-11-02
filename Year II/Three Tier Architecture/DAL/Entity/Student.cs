using System;
using System.Collections.Generic;
using System.Text;
using System.Xml.Serialization;

namespace DAL
{
    [Serializable]
    public class Student : Entity
    {
        public string _course { get; set; }
        public string _studentID { get; set; }
        public string _sex { get; set; }
        public string _GPA { get; set; }
        public string _creditBookID { get; set; }
        [XmlIgnore] public IComposeStory story;
        public void SetStory(IComposeStory cs)
        {
            story = cs;
        }
        public Student()
        {

        }
        public Student(string[] source)
        {
            _firstName = source[0];
            _secondName = source[1];
            _course = source[2];
            _studentID = source[3];
            _sex = source[4];
            _GPA = source[5];
            _creditBookID = source[6];
            SetStory(new StudentStory());
        }
        public Student(Student student)
        {
            _firstName = student._firstName;
            _secondName = student._secondName;
            _course = student._course;
            _studentID = student._studentID;
            _sex = student._sex;
            _GPA = student._GPA;
            _creditBookID = student._creditBookID;
            SetStory(new StudentStory());
        }

        public override string ToString()
        {
            return $"Student: {_firstName}{_secondName}\n" +
                $"firstName: {_firstName}\n" +
                $"secondName: {_secondName}\n" +
                $"course: {_course}\n" +
                $"studentID: {_studentID}\n" +
                $"sex: {_sex}\n" +
                $"GPA: {_GPA}\n" +
                $"creditBookID: {_creditBookID}\n";
        }
    }
}
