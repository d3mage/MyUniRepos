using System;
using System.Collections.Generic;
using System.Text;

namespace Layers_and_Serialization_II.Providers
{
    class ReadWriteService<T>
    {
        private IDataContext<T> _dataContext;
        public ReadWriteService(IDataContext<T> dataContext)
        {
            _dataContext = dataContext;
        }

        public T ReadData()
        {
            return _dataContext.GetData();
        }

        public void WriteData(T data)
        {
            _dataContext.SetData(data);
        }
    }
}
