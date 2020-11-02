using System;
using System.Collections.Generic;
using System.Text;

namespace BLL
{
   public class FileNameGenerator
    {
        public string GenerateFileName(string name, string extension)
        {
            return $"{name}.{extension}";
        }
    }
}
