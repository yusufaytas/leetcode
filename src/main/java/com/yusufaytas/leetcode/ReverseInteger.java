package com.yusufaytas.leetcode;

/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
 */
public class ReverseInteger {

  public int reverse(int x) {
    StringBuilder builder = new StringBuilder(Long.toString(x).replace("-", ""));
    long number = Long.parseLong(builder.reverse().toString());
    number = x < 0 ? -number : number;
    if (number > Integer.MAX_VALUE || number < Integer.MIN_VALUE) {
      return 0;
    }
    return (int) number;
  }
}
