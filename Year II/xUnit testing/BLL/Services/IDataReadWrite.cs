using System;
using System.Collections.Generic;
using System.Text;

namespace BLL
{
    public interface IDataReadWrite<T>
    {
        T[] ReadData();
        void WriteData(T[] data);
    }
}
