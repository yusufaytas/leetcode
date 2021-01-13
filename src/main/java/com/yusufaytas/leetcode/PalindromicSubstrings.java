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
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

 */
public class PalindromicSubstrings {

  public static void main(String[] args) {
    final String s = "aaa";
    System.out.println(new PalindromicSubstrings().countSubstrings(s));
  }

  public int countSubstrings(final String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    final int[][] visited = new int[s.length()][s.length()];

    return countSubstrings(s, 0, s.length() - 1, visited);
  }

  private int countSubstrings(final String s, final int startIndex, final int endIndex,
      final int[][] visited) {
    if (startIndex > endIndex || endIndex < 0 || startIndex == s.length()
        || visited[startIndex][endIndex] != 0) {
      return 0;
    }
    int count = 0;
    if (isPalindrome(s, startIndex, endIndex)) {
      count++;
    }
    count += countSubstrings(s, startIndex + 1, endIndex, visited);
    count += countSubstrings(s, startIndex, endIndex - 1, visited);
    visited[startIndex][endIndex] = count;
    return count;
  }

  public boolean isPalindrome(final String s, final int startIndex, final int endIndex) {
    for (int i = 0; i <= (endIndex - startIndex) / 2; i++) {
      if (s.charAt(startIndex + i) != s.charAt(endIndex - i)) {
        return false;
      }
    }
    return true;
  }
}
