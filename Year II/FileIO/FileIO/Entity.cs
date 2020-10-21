using MainClass;

namespace FileIO
{
    abstract class Entity
    {
        protected string _firstName, _secondName;

        protected IComposeStory story;

        public string FirstName => _firstName;
        public string SecondName => _secondName;

        public void setStory(IComposeStory cs)
        {
            story = cs;
        }
    }

    class Student : Entity
    {
        private string _course;
        private string _studentID;
        private string _sex;
        private string _GPA;
        private string _creditBookID;

        public string Course => _course;
        public string StudentID => _studentID;
        public string Sex => _sex;
        public string GPA => _GPA;
        public string CreditBookID => _creditBookID;


        public Student(string[] source)
        {
            _firstName = source[0];
            _secondName = source[1];
            _course = source[2];
            _studentID = source[3];
            _sex = source[4];
            _GPA = source[5];
            _creditBookID = source[6];
            setStory(new StudentStory());
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
            setStory(new StudentStory());
        }

        public override string ToString()
        {
            return $"Student: {FirstName}{SecondName}\n" +
                $"firstName: {FirstName}\n" +
                $"secondName: {SecondName}\n" +
                $"course: {_course}\n" +
                $"studentID: {_studentID}\n" +
                $"sex: {_sex}\n" +
                $"GPA: {_GPA}\n" +
                $"creditBookID: {_creditBookID}\n";
        }
    }

    class Doctor : Entity
    {
        private string _medicineField;
        private string _yearsOfExp;

        public string MedicineField => _medicineField;
        public string YearsOfExp => _yearsOfExp;

        public Doctor(string[] source)
        {
            _firstName = source[0];
            _secondName = source[1];
            _medicineField = source[2];
            _yearsOfExp = source[3];
            setStory(new DoctorStory());
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
            return $"Doctor: {FirstName}{SecondName}\n" +
                   $"firstName: {FirstName}\n" +
                   $"secondName: {SecondName}\n" +
                   $"medicineField: {_medicineField}" +
                   $"yearsOfExp: {_yearsOfExp}";
        }
    }

    class Mechanic : Entity
    {
        private string _typeOfTransport;
        private string _education;

        public string TypeOfTransport => _typeOfTransport;
        public string Education => _education;

        public Mechanic(string[] source)
        {
            _firstName = source[0];
            _secondName = source[1];
            _typeOfTransport = source[2];
            _education = source[3];
            setStory(new MechanicStory());
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
            return $"Mechanic: {FirstName}{SecondName}\n" +
                $"firstName: {FirstName}\n" +
                $"secondName: {SecondName}\n" +
                $"typeOfTransport: {_typeOfTransport}" +
                $"edcation: {_education}";
        }
    }
}
