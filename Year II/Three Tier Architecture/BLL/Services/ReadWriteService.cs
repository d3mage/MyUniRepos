using DAL;

namespace BLL
{
    public class ReadWriteService<T> : IDataReadWrite<T>
    {
        private IDataContext<T> _dataContext;
        public ReadWriteService(IDataContext<T> dataContext)
        {
            _dataContext = dataContext;
        }

        public T[] ReadData()
        {
            return _dataContext.GetData();
        }

        public void WriteData(T[] data)
        {
            _dataContext.SetData(data);
        }
    }
}
