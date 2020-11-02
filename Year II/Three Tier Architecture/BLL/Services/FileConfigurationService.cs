using DAL;
using Provider;

namespace BLL
{
    public class FileConfigurationService<T>
    {
        public IDataReadWrite<T> ConfigureFileService(string name, string extension, string entity, FileNameGenerator nameGenerator)
        {
            string connectionString = nameGenerator.GenerateFileName(name, extension, entity);
            IDataContext<T> tempContext = new EntityContext<T>(connectionString);
            tempContext.DataProvider = ExtensionSelection(extension);
            IDataReadWrite<T> tempReadWrite = new ReadWriteService<T>(tempContext);
            return tempReadWrite; 
        }
        
       
        private IDataProvider<T> ExtensionSelection(string extension)
        {
            switch (extension)
            {
                //case "json":
                //    return new JsonProvider<T>(); 
                case "xml":
                    return new XMLDataProvider<T>();
                default:
                    return new XMLDataProvider<T>();
            }
        }
    }
}
