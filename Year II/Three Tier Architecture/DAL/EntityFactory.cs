using System;
using System.Collections.Generic;
using System.Text;

namespace DAL
{
    public class EntityFactory : IEntityFactory
    {
        public Entity CreateInstance(string name, string[] data)
        {
            switch (name)
            {
                case "student":
                    return new Student(data);
                case "doctor":
                    return new Doctor(data);
                case "mechanic":
                    return new Mechanic(data);
                default:
                    return null; 
            }
        }
    }
}
