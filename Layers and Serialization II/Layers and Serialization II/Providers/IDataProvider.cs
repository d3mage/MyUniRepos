using System;
using System.Collections.Generic;
using System.Text;

namespace Layers_and_Serialization_II
{
    public interface IDataProvider<T>
    {
        void Write(T data, string connection);
        T Read(string connection);
    }
}
