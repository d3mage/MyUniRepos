using System.IO;

namespace ReadWrite
{
    public class ReadWrite
    {
        public static void Read(string path, out string dataString)
        {
            try
            {
                using (StreamReader sr = new StreamReader(path))
                {
                    dataString = sr.ReadToEnd();
                }
            }
            catch (FileNotFoundException e)
            {
                System.Console.WriteLine(e.Message);
                dataString = "";
            }
        }

        public static void Flush(string path)
        {
            using (StreamWriter sw = new StreamWriter(path, false))
            {
            }
        }

        public static void Write(string path, string text)
        {
            using (StreamWriter sw = new StreamWriter(path, true, System.Text.Encoding.Default))
            {
                sw.WriteLine(text);
            }
        }
    }
}
