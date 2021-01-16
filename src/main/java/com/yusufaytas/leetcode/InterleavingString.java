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
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

    s = s1 + s2 + ... + sn
    t = t1 + t2 + ... + tm
    |n - m| <= 1
    The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...

Note: a + b is the concatenation of strings a and b.



Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true

Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false

Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true

 */
public class InterleavingString {

  public boolean isInterleave(final String s1, final String s2, final String s3) {
    if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
      return false;
    }
    if ((s1.length() == 0 && s2.equals(s3)) || (s2.length() == 0 && s1.equals(s3))) {
      return true;
    }
    final int[][] indexes = new int[s1.length()][s2.length()];
    return isInterleave(s1, 0, s2, 0, s3, 0, indexes);
  }

  public boolean isInterleave(final String s1, final int s1Index,
      final String s2, final int s2Index,
      final String s3, final int s3Index,
      final int[][] indexes) {
    if (s1Index < s1.length() && s2Index < s2.length() && indexes[s1Index][s2Index] != 0) {
      return indexes[s1Index][s2Index] == 1;
    }
    boolean isInterleave = false;
    if (s1Index == s1.length()) {
      isInterleave = s3.substring(s3Index).equals(s2.substring(s2Index));
    } else if (s2Index == s2.length()) {
      isInterleave = s3.substring(s3Index).equals(s1.substring(s1Index));
    } else {
      if (s1.charAt(s1Index) == s3.charAt(s3Index)) {
        isInterleave = isInterleave(s1, s1Index + 1, s2, s2Index, s3, s3Index + 1, indexes);
      }
      if (!isInterleave && s2.charAt(s2Index) == s3.charAt(s3Index)) {
        isInterleave = isInterleave(s1, s1Index, s2, s2Index + 1, s3, s3Index + 1, indexes);
      }
    }
    if (s1Index < s1.length() && s2Index < s2.length()){
      indexes[s1Index][s2Index] = isInterleave ? 1 : -1;
    }
    return isInterleave;
  }

  public static void main(String[] args) {
    final String s1 = "aabcc";
    final String s2 = "dbbca";
    final String s3 = "aadbbbaccc";
    System.out.println(new InterleavingString().isInterleave(s1, s2, s3));
  }
}
