using System;
using System.Collections.Generic;
using System.Text;

namespace Layers_and_Serialization_II
{
    class EntityContext<T>
    {
        private T _storedData;

        public string ConnectionString { get; }
        public IDataProvider<T> DataProvider { get; set; }

        public T GetData()
        {
            if (DataProvider != null)
            {
                if (_storedData != null)
                    return _storedData;
                else
                {
                    try
                    {
                        _storedData = DataProvider.Read(ConnectionString);
                    }
                    catch (Exception ex)
                    {
                        throw ex;
                    }
                    return _storedData;
                }
            }
            else
                throw new InvalidOperationException("Data provider is undefined");
        }

        public void SetData(T data)
        {
            if (DataProvider != null)
            {
                DataProvider.Write(data, ConnectionString);
                _storedData = data;
            }
            else
                throw new InvalidOperationException("Data provider is undefined");
        }
    }
}
