using System;
using System.Collections.Generic;
using System.Text;

namespace Provider
{
    public interface IDataProvider<T>
    {
        void Write(T[] data, string connection);
        T[] Read(string connection);
    }
}
