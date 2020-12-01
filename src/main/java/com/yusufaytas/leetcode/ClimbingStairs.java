package com.yusufaytas.leetcode;

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */
public class ClimbingStairs {

  public int climbStairs(final int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    final int[] stairs = new int[n];
    stairs[0] = 1;
    stairs[1] = 2;
    for (int i = 2; i < n; i++) {
      stairs[i] = stairs[i - 1] + stairs[i - 2];
    }
    return stairs[n - 1];
  }

  public static void main(String[] args) {
    System.out.println(new ClimbingStairs().climbStairs(3));
  }
}
