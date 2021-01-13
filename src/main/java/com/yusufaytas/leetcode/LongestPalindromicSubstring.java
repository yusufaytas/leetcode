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

/*
{{REVISIT}}
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
Example:
Input: "babad"
Output: "bab"

Note: "aba" is also a valid answer.
Example:
Input: "cbbd"
Output: "bb"
 */
public class LongestPalindromicSubstring {

  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }

    String maxPalindrome = "";
    boolean[][] palindromes = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      palindromes[i][i] = true;
      maxPalindrome = s.substring(i, i + 1);
    }

    for (int i = 0; i < s.length() - 1; i++) {
      palindromes[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
      if (palindromes[i][i + 1]) {
        maxPalindrome = s.substring(i, i + 2);
      }
    }

    for (int j = 2; j < s.length(); j++) {
      for (int i = 0; i + j < s.length(); i++) {
        palindromes[i][i + j] = s.charAt(i) == s.charAt(i + j) && palindromes[i + 1][i + j - 1];
        if (j + 1 > maxPalindrome.length() && palindromes[i][i + j]) {
          maxPalindrome = s.substring(i, i + j + 1);
        }
      }
    }
    return maxPalindrome;
  }

}
