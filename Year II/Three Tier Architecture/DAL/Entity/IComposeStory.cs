using System;
using System.Collections.Generic;
using System.Text;

namespace DAL
{
    public interface IComposeStory
    {
        void ComposeStory();
    }

    class StudentStory : IComposeStory
    {
        public void ComposeStory()
        {
            Console.WriteLine("Hmm, well, last year we were actually studying, \n" +
                "can you imagine that one");
        }
    }

    class DoctorStory : IComposeStory
    {
        public void ComposeStory()
        {
            Console.WriteLine("I did a 24-hour surgery once. Hell, that was tough");
        }
    }

    class MechanicStory : IComposeStory
    {
        public void ComposeStory()
        {
            Console.WriteLine("Bloody hell, there was a mate, I don't even know how " +
                "he managed to get to our service. His car was a disaster");
        }
    }
}
