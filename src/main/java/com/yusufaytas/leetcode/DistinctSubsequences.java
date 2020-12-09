package com.yusufaytas.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t, return the number of distinct subsequences of s which equals t.

A string's subsequence is a new string formed from the original string by deleting
some (can be none) of the characters without disturbing the relative positions of
the remaining characters. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).

It's guaranteed the answer fits on a 32-bit signed integer.

Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from S.
rabbbit
rabbbit
rabbbit

Example 2:

Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from S.
babgbag
babgbag
babgbag
babgbag
babgbag
 */
public class DistinctSubsequences {

  public int numDistinct(final String s, final String t) {
    if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
      return 0;
    }
    final Map<String, Integer>[] counts = new Map[s.length()];
    for (int i = 0; i < s.length(); i++) {
      counts[i] = new HashMap<>();
    }
    findCount(s, t, 0, counts);
    for (int i = 0; i < counts.length; i++) {
      if (counts[i].getOrDefault(t, -1) != -1) {
        return counts[i].get(t);
      }
    }
    return 0;
  }

  public int findCount(final String s, final String current, final int index,
      final Map<String, Integer>[] counts) {
    if (current.isEmpty()) {
      return 1;
    }
    if (index == s.length() || s.length() - index < current.length()) {
      return -1;
    }
    if (counts[index].containsKey(current)) {
      return counts[index].get(current);
    }
    final int sameCount = findCount(s, current, index + 1, counts);
    final int substringCount = current.charAt(0) == s.charAt(index) ?
        findCount(s, current.substring(1), index + 1, counts) : -1;
    if (sameCount < 0 && substringCount < 0) {
      counts[index].put(current, -1);
    } else {
      counts[index].put(current, Math.max(sameCount, 0) + Math.max(substringCount, 0));
    }
    return counts[index].get(current);
  }

  public static void main(String[] args) {
    final String s = "aaabbbbbaaaaa";
    final String t = "bbaab";
    System.out.println(new DistinctSubsequences().numDistinct(s, t));
  }
}
