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
Given a string s and a string t, check if s is subsequence of t.

A subsequence of a string is a new string which is formed from the original
string by deleting some (can be none) of the characters without disturbing
the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want
to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false

 */
public class IsSubsequence {

  public boolean isSubsequence(final String s, final String t) {
    if (t == null || s == null || t.length() < s.length()) {
      return false;
    }
    if (s.length() == 0) {
      return true;
    }
    for (int i = 0, j = 0; i < t.length(); i++) {
      if (s.charAt(j) == t.charAt(i)) {
        if (++j == s.length()) {
          return true;
        }
      }
    }
    return false;
  }
}
