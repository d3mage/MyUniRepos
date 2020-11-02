using System;
using System.Collections.Generic;
using System.Text;
using System.Xml.Serialization;

namespace DAL
{
    [XmlInclude(typeof(Student))]
    [Serializable]
    public abstract class Entity
    {
        public string _firstName, _secondName;

        //public IComposeStory story;

        public Entity()
        {

        }

        //public void SetStory(IComposeStory cs)
        //{
        //    story = cs;
        //}
    }
}
