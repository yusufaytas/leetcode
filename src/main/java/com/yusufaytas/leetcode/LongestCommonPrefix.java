package com.yusufaytas.leetcode;

/*
Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

  public static void main(String[] args) {
    System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{}));
  }

  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    int current = 0;
    boolean stop = false;
    StringBuilder builder = new StringBuilder();
    while (!stop) {
      Character c = null;
      for (int i = 0; i < strs.length; i++) {
        if (strs[i] != null && strs[i].length() > current) {
          if (c == null) {
            c = strs[i].charAt(current);
          }
          if (c != strs[i].charAt(current)) {
            stop = true;
          }
        } else {
          stop = true;
        }
      }
      if (!stop) {
        builder.append(c);
        current++;
      }
    }
    return builder.toString();
  }
}
