/**
 * Copyright © 2021 Yusuf Aytas. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
