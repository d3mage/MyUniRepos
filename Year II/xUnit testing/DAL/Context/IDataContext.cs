using System;
using System.Collections.Generic;
using System.Text;
using Provider;

namespace DAL
{
    public interface IDataContext<T>
    {
        string ConnectionString { get; }
        IDataProvider<T> DataProvider { get; set; }
        T[] GetData();
        void SetData(T[] data);
    }
}
