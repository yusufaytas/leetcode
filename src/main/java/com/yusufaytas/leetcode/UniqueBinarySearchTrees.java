package com.yusufaytas.leetcode;

/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 1        1       1       1      1
  \        \       \       \      \
   4        4       2       2      3
  /        /         \       \     / \
  2       3           4       3   2   4
  \      /           /         \
   3    2           3           4
 */
public class UniqueBinarySearchTrees {

  public int numTrees(final int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    final int[] allTrees = new int[n + 1];
    allTrees[0] = 1;
    allTrees[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        allTrees[i] += allTrees[j - 1] * allTrees[i - j];
      }
    }
    return allTrees[n];
  }

  public static void main(String[] args) {
    System.out.println(new UniqueBinarySearchTrees().numTrees(110));
  }
}
