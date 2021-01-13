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

import java.util.Arrays;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aabcbd" =>
i=0: a      | [0, 4, 4, 4, 4]
i=1: aa     | [0, 0, 4, 4, 4]
i=2: aab    | [0, 0, 1, 4, 4]
i=3: aabc   | [0, 0, 1, 2, 4]
i=4: aabcb  | [0, 0, 1, 2, 1]
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioning2 {

  public static void main(String[] args) {
    String s = "aabb";
    System.out.println(new PalindromePartitioning2().minCut(s));
  }

  public int minCut(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    boolean palindromes[][] = getPalindromes(s);
    int[] minCuts = findMinCuts(s, palindromes);

    return minCuts[s.length() - 1];
  }

  private int[] findMinCuts(String s, boolean[][] palindromes) {
    int[] minCuts = new int[s.length()];
    Arrays.fill(minCuts, s.length() - 1);

    for (int i = 0; i < minCuts.length; i++) {
      for (int j = 0; j <= i; j++) {
        if (palindromes[j][i]) {
          minCuts[i] = j == 0 ? 0 : Math.min(minCuts[i], minCuts[j - 1] + 1);
        }
      }
    }
    return minCuts;
  }

  private boolean[][] getPalindromes(String s) {
    boolean palindromes[][] = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j <= i; j++) {
        if (i == j) {
          palindromes[j][i] = true;
        } else if (s.charAt(i) == s.charAt(j)) {
          if (i - j == 1) {
            palindromes[j][i] = true;
          } else if (i - j > 1) {
            palindromes[j][i] = palindromes[j + 1][i - 1];
          }
        }
      }
    }
    return palindromes;
  }
}
