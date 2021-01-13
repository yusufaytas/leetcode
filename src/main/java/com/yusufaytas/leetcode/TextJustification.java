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

Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.
 */
public class TextJustification {

  public static void main(String[] args) {
    int maxWidth = 2;
    String[] words = {""};
    System.out.println(new TextJustification().fullJustify(words, maxWidth));
  }

  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> lines = new ArrayList<String>();
    int index = 0;
    while (index < words.length) {
      int currentIndex = index, sumLength = 0;
      while (currentIndex < words.length
          && ((sumLength == 0 ? 0 : 1) + sumLength + words[currentIndex].length()) <= maxWidth) {
        sumLength += (sumLength == 0 ? 0 : 1) + words[currentIndex].length();
        currentIndex++;
      }
      if (currentIndex >= words.length
          || ((sumLength == 0 ? 0 : 1) + sumLength + words[currentIndex].length()) > maxWidth) {
        currentIndex--;
      }
      int noOfWords = currentIndex - index + 1;
      int spaces = maxWidth - sumLength + noOfWords - 1, remainingSpaces =
          noOfWords == 1 ? spaces : (spaces - (spaces / (noOfWords - 1) * (noOfWords - 1)));
      String line = "";
      if (currentIndex == words.length - 1) {
        for (int i = index; i <= currentIndex; i++) {
          if (line.length() != 0) {
            line += " ";
          }
          line += words[i];
        }
        int currentLength = line.length();
        for (int j = 0; j < maxWidth - currentLength; j++) {
          line += " ";
        }
      } else {
        for (int i = index; i <= currentIndex; i++) {
          if (line.length() != 0) {
            int currentSpaces = (spaces / (noOfWords - 1)) + (remainingSpaces-- > 0 ? 1 : 0);
            for (int j = 0; j < currentSpaces; j++) {
              line += " ";
            }
          }
          line += words[i];
        }
        if (noOfWords == 1) {
          for (int j = 0; j < spaces; j++) {
            line += " ";
          }
        }
      }
      lines.add(line);
      index = currentIndex + 1;
    }
    return lines;
  }
}
