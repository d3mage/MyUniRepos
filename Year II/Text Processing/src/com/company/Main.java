package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<String> GetLongestWord(String[] stringArray)
    {
        int longestCount = 0;
        ArrayList<String> longestWords = new ArrayList<String>();

        for (String word : stringArray)
        {
            if(word.length() > longestCount)
            {
                longestCount = word.length();
            }
        }
        for(String word : stringArray)
        {
            if(word.length() == longestCount)
            {
                longestWords.add(word);
            }
        }

        return longestWords;
    }

    public static void main(String[] args)
    {
	  String textString = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque imperdiet enim urna, " +
              "ut tempus dui vulputate eu. In accumsan velit tincidunt nisi suscipit bibendum. Etiam congue congue sodales. " +
              "Cras nec dui lorem. Etiam dignissim scelerisque turpis et consequat. Aenean id nunc quis nunc pretium tempus. " +
              "Mauris sagittis dignissim neque, in pellentesque odio imperdiet vel. Nam ut aliquam lectus, sit amet mollis justo." +
              " Ut feugiat felis urna, vel aliquam massa tincidunt sed. Praesent iaculis urna nec suscipit malesuada. ";

	  String[] stringArray = textString.split("\\W+");

	  System.out.println(GetLongestWord(stringArray));
    }
}
