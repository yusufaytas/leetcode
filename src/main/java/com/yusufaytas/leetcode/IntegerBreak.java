package com.yusufaytas.leetcode;

public class IntegerBreak {

  public int integerBreak(final int n) {
    if (n == 2) {
      return 1;
    }
    if (n == 3) {
      return 2;
    }
    final int[] products = new int[n + 1];
    products[1] = 1;
    products[2] = 2;
    products[3] = 3;
    for (int i = 4; i <= n; i++) {
      products[i] = Math.max(products[i - 2] * 2, products[i - 3] * 3);
    }
    return products[n];
  }

  public static void main(String[] args) {
    System.out.println(new IntegerBreak().integerBreak(11));
  }
}
