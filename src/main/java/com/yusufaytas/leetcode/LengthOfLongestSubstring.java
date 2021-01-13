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
Given a string, find the length of the longest substring without repeating characters.
Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LengthOfLongestSubstring {

  public int lengthOfLongestSubstring(String s) {
    if (s == null) {
      return 0;
    }
    int maxLengthSoFar = 0;
    for (int i = 0; i < s.length(); i++) {
      Set<Character> longestSubString = new HashSet<Character>();
      for (int j = i; j < s.length(); j++) {
        char c = s.charAt(j);
        if (longestSubString.contains(c)) {
          break;
        }
        longestSubString.add(c);
      }
      if (maxLengthSoFar < longestSubString.size()) {
        maxLengthSoFar = longestSubString.size();
      }
    }
    return maxLengthSoFar;
  }

}

