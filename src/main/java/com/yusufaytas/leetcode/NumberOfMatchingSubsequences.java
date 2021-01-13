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
Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

Example :
Input:
S = "abcde"
words = ["a", "bb", "acd", "ace"]
Output: 3
Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".

Note:
    All words in words and S will only consists of lowercase letters.
    The length of S will be in the range of [1, 50000].
    The length of words will be in the range of [1, 5000].
    The length of words[i] will be in the range of [1, 50].
 */
public class NumberOfMatchingSubsequences {

  public int numMatchingSubseq(final String S, final String[] words) {
    if (S == null || S.length() == 0 || words == null || words.length == 0) {
      return 0;
    }
    final int[][] letterCount = new int[26][S.length()];
    for (int i = 0; i < 26; i++) {
      Arrays.fill(letterCount[i], -1);
    }
    letterCount[S.charAt(S.length() - 1) - 'a'][S.length() - 1] = S.length() - 1;
    for (int i = S.length() - 2; i >= 0; i--) {
      for (int j = 0; j < 26; j++) {
        letterCount[j][i] = letterCount[j][i + 1];
      }
      letterCount[S.charAt(i) - 'a'][i] = i;
    }
    int matchingCount = 0;
    for (int i = 0; i < words.length; i++) {
      int current = 0;
      for (int j = 0; j < words[i].length(); j++) {
        if (current >= S.length() || letterCount[words[i].charAt(j) - 'a'][current] < 0) {
          matchingCount--;
          break;
        }
        current = letterCount[words[i].charAt(j) - 'a'][current] + 1;
      }
      matchingCount++;
    }
    return matchingCount;
  }

  public static void main(String[] args) {
    final String S = "iwdlcxpyagegrcnrcylxolxlnhhwnxyzltiscrjztiivnpnzlubzpueihinsqdfvypdteztiodbhaqhxskupwulvkzhczdyoouym";
    final String[] words = {"hhwnxyzltiscrjztiivnpnzlubzpueihinsqdfvyp",
        "vnpnzlubzpueihinsqdfvypdteztiodbha", "rcnrcylxolxlnhhwnxyzltiscrjztiivnpnzlubzpueihi",
        "dfvypdteztiodbhaqhxskupwulvk", "zltiscrjztii",
        "wdmbatbcewwittubryrqwwrvfkrmniomofygybeqfzusrgeart",
        "myzfexqmzxnbmmnhmpbddqhrwrobqzjiwdzzpyzodejysuuquc",
        "wxvrcbihbasohfvuwuxleesqeujxvjfvgwnhltenbspdgzsdrs",
        "nztyysfhfbfcihyeaqdarqxfpjunevabzafvbmpbtenarvyizv",
        "nivufheyodfjuggrbndyojeahrzgptikjfqufhwyhzyyjteahx"};
    System.out.println(new NumberOfMatchingSubsequences().numMatchingSubseq(S, words));
  }
}
