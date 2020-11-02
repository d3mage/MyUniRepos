using System;
using System.Collections.Generic;
using System.Text;

namespace DAL
{
    interface IEntityFactory
    {
        Entity CreateInstance(string name, string[] data);
    }
}
