package com.yusufaytas.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToInteger {

  public int myAtoi(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    Matcher matcher = Pattern.compile("\\d+").matcher(str);
    if (!matcher.find()) {
      return 0;
    }
    String cleanStr = matcher.group();
    if (cleanStr.length() == 0) {
      return 0;
    }
    if (cleanStr.length() > 11) {
      if (str.contains("-")) {
        return Integer.MIN_VALUE;
      }
      return Integer.MAX_VALUE;
    }
    if (str.contains("-") && str.contains("+")) {
      return 0;

    }
    long number = Long.parseLong(cleanStr);
    if (str.contains("-")) {
      number = -number;
    }

    if (number > Integer.MAX_VALUE || number < Integer.MIN_VALUE) {
      if (str.contains("-")) {
        return Integer.MIN_VALUE;
      }
      return Integer.MAX_VALUE;
    }
    return (int) number;
  }
}
