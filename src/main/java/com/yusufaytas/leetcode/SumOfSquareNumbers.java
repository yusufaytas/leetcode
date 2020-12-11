package com.yusufaytas.leetcode;

/*
Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:

Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5

Example 2:

Input: c = 3
Output: false

Example 3:

Input: c = 4
Output: true

Example 4:

Input: c = 2
Output: true

Example 5:

Input: c = 1
Output: true
 */
public class SumOfSquareNumbers {

  public boolean judgeSquareSum(final int c) {
    for (int i = 0; i <= Math.sqrt(c); i++) {
      final double remaining = Math.sqrt(c - (int) Math.pow(i, 2));
      if (remaining == (int) remaining) {
        return true;
      }
    }
    return false;
  }
}
