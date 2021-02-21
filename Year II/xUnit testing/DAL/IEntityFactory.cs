using System;
using System.Collections.Generic;
using System.Text;

namespace DAL
{
    public interface IEntityFactory
    {
        Entity CreateInstance(string name, string[] data);
    }
}
