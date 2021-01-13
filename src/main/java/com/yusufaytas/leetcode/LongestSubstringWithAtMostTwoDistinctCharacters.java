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

import java.util.HashSet;
import java.util.Set;

/*
"cabbaaaccccc" -> "abbaaa"

 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

  public String findSubstring(final String s) {
    if (s == null) {
      return "";
    }
    int startIndexFirst = 0, startIndexRepeat = 0, max = 0, startIndexMax = 0, endIndexMax = 0;
    final Set<Character> buffer = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      final char c = s.charAt(i);
      if (buffer.size() == 2 && !buffer.contains(c)) {
        startIndexFirst = startIndexRepeat;
        buffer.clear();
        buffer.add(s.charAt(startIndexFirst));
      }
      buffer.add(c);
      if (i > 0 && s.charAt(i - 1) != c) {
        startIndexRepeat = i;
      }
      if (i - startIndexFirst > max) {
        max = i - startIndexFirst;
        startIndexMax = startIndexFirst;
        endIndexMax = i;
      }
    }
    if (buffer.size() < 2) {
      return "";
    }
    return s.substring(startIndexMax, endIndexMax + 1);
  }

  public static void main(String[] args) {
    final String s = "a";
    System.out.println(new LongestSubstringWithAtMostTwoDistinctCharacters().findSubstring(s));
  }
}
