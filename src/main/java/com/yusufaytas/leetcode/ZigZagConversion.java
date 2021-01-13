/**
 * Copyright © 2021 Yusuf Aytas. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
public class ZigZagConversion {

  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }

    List<List<Character>> zigZagList = new ArrayList<List<Character>>();
    for (int i = 0; i < numRows; i++) {
      zigZagList.add(new ArrayList<Character>());
    }
    for (int i = 0; i < s.length(); i++) {
      int index = getIndex(numRows, i);
      zigZagList.get(index).add(s.charAt(i));
    }
    StringBuilder builder = new StringBuilder();
    for (List<Character> characters : zigZagList) {
      for (Character character : characters) {
        builder.append(character);
      }
    }
    return builder.toString();
  }

  private int getIndex(int numRows, int i) {
    int index = i % (numRows + numRows - 2);
    if (index >= numRows) {
      return 2 * numRows - index - 2;
    }
    return index;
  }

}
