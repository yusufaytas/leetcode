package com.yusufaytas.leetcode;

import java.util.Arrays;

/*
Initially on a notepad only one character 'A' is present.
You can perform two operations on this notepad for each step:

    Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
    Paste: You can paste the characters which are copied last time.

Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum
number of steps permitted. Output the minimum number of steps to get n 'A'.

Example 1:

Input: 3
Output: 3
Explanation:
Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.

 */
public class TwoKeysKeyboard {

  public int minSteps(final int n) {
    if (n < 2) {
      return 0;
    }
    final int[][] steps = new int[n + 1][n + 1];
    for (int i = 0; i < steps.length; i++) {
      Arrays.fill(steps[i], n);
    }
    steps[1][1] = 1;
    for (int i = 2; i <= n; i++) {
      int min = n;
      for (int j = 1; j <= i / 2; j++) {
        steps[i][j] = steps[i - j][j] + (i - j == j && j != 1 ? 2 : 1);
        min = Math.min(min, steps[i][j]);
      }
      steps[i][i] = min;
    }
    return steps[n][n];
  }

  public static void main(String[] args) {
    System.out.println(new TwoKeysKeyboard().minSteps(8));
  }
}
