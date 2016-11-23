package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion
{
    public String convert(String s, int numRows)
    {
        if (numRows == 1)
        {
            return s;
        }

        List<List<Character>> zigZagList = new ArrayList<List<Character>>();
        for (int i = 0; i < numRows; i++)
        {
            zigZagList.add(new ArrayList<Character>());
        }
        for (int i = 0; i < s.length(); i++)
        {
            int index = getIndex(numRows, i);
            zigZagList.get(index).add(s.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        for (List<Character> characters : zigZagList)
        {
            for (Character character : characters)
            {
                builder.append(character);
            }
        }
        return builder.toString();
    }

    private int getIndex(int numRows, int i)
    {
        int index = i % (numRows + numRows - 2);
        if (index >= numRows)
        {
            return 2 * numRows - index - 2;
        }
        return index;
    }
    
}
