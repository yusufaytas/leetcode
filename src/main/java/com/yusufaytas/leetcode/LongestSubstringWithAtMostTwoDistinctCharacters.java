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
