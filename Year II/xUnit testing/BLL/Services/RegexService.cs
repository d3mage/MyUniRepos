using System;
using System.Collections.Generic;
using System.Text;
using System.Text.RegularExpressions;

namespace BLL
{ 
    public class RegexService
    {
        public bool isCorrectRegex(string toCompare, string regexString)
        {
            return Regex.IsMatch(toCompare, regexString) ? true : false; 
        }
    }
}
