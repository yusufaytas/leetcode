package com.yusufaytas.leetcode;

public class ExcelSheetColumnTitle {

  public String convertToTitle(int n) {
    final StringBuilder titleBuilder = new StringBuilder();
    while (n > 0) {
      titleBuilder.append((char) ((n - 1) % 26 + 'A'));
      n = (n - 1) / 26;
    }
    return titleBuilder.reverse().toString();
  }
}
