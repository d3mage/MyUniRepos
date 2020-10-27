using System;
using System.Collections.Generic;
using System.Text;

namespace Layers_and_Serialization_II
{
    interface IDataReadWrite<T>
    {
        T ReadData();
        void WriteData(T data);
    }
}
