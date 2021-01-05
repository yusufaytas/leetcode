package com.yusufaytas.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
Strings A and B are K-similar (for some non-negative integer K) if we can swap the positions
of two letters in A exactly K times so that the resulting string equals B.

Given two anagrams A and B, return the smallest K for which A and B are K-similar.

Example 1:

Input: A = "ab", B = "ba"
Output: 1

Example 2:

Input: A = "abc", B = "bca"
Output: 2

Example 3:

Input: A = "abac", B = "baca"
Output: 2

Example 4:

Input: A = "aabc", B = "abca"
Output: 2
 */
public class KSimilarStrings {

  public int kSimilarity(final String A, final String B) {
    if (A == null || B == null || A.length() != B.length()) {
      return -1;
    }
    final Queue<SimilarString> queue = new ArrayDeque<>();
    final Set<String> visited = new HashSet<>();
    queue.add(new SimilarString(A, 0));
    while (!queue.isEmpty()) {
      final SimilarString next = queue.poll();
      final List<Integer> differentIndexes = new ArrayList<>();
      for (int i = 0; i < B.length(); i++) {
        if (next.str.charAt(i) != B.charAt(i)) {
          differentIndexes.add(i);
        }
      }
      if (differentIndexes.isEmpty()) {
        return next.level;
      }
      if (!visited.add(next.str)) {
        continue;
      }
      visitNext(B, queue, next, differentIndexes);
    }
    return -1;
  }

  private void visitNext(final String B, final Queue<SimilarString> queue,
      final SimilarString next, final List<Integer> differentIndexes) {
    for (final int i : differentIndexes) {
      for (final int j : differentIndexes) {
        if (i == j) {
          continue;
        }
        if (B.charAt(j) == next.str.charAt(i) && next.str.charAt(j) == B.charAt(i)) {
          final StringBuilder builder = new StringBuilder(next.str);
          builder.setCharAt(i, next.str.charAt(j));
          builder.setCharAt(j, next.str.charAt(i));
          queue.add(new SimilarString(builder.toString(), next.level + 1));
          return;
        }
      }
    }
    for (final int i : differentIndexes) {
      for (final int j : differentIndexes) {
        if (i == j) {
          continue;
        }
        if (B.charAt(j) == next.str.charAt(i) || next.str.charAt(j) == B.charAt(i)) {
          final StringBuilder builder = new StringBuilder(next.str);
          builder.setCharAt(i, next.str.charAt(j));
          builder.setCharAt(j, next.str.charAt(i));
          queue.add(new SimilarString(builder.toString(), next.level + 1));
        }
      }
    }
  }

  private static class SimilarString {

    final String str;
    final int level;

    public SimilarString(final String str, final int level) {
      this.level = level;
      this.str = str;
    }
  }

  public static void main(String[] args) {
    final String A = "abccaacceecdeea";
    final String B = "bcaacceeccdeaae";
    System.out.println(new KSimilarStrings().kSimilarity(A, B));
  }
}
