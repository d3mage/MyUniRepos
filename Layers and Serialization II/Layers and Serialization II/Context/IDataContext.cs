using System;
using System.Collections.Generic;
using System.Text;

namespace Layers_and_Serialization_II
{
    interface IDataContext<T>
    {
        string ConnectionString { get; }
        IDataProvider<T> DataProvider { get; set; }
        T GetData();
        void SetData(T data);
    }
}
