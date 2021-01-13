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

import java.util.ArrayList;
import java.util.List;

/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.

Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */
public class PerfectSquares {

  public static void main(String[] args) {
    System.out.println(new PerfectSquares().numSquares(23));
  }

  public int numSquares(final int n) {
    final List<Integer> squares = new ArrayList<>();
    for (int i = 1; i * i <= n; i++) {
      squares.add(i * i);
    }
    final int[][] sums = new int[n + 1][squares.size() + 1];
    for (int i = 0; i <= n; i++) {
      sums[i][0] = 0;
    }
    for (int i = 0; i <= squares.size(); i++) {
      sums[0][i] = 0;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= squares.size(); j++) {
        if (i - squares.get(j - 1) >= 0) {
          sums[i][j] = sums[i - squares.get(j - 1)][j] + 1;
        }
        if (sums[i][j - 1] > 0) {
          sums[i][j] = Math.min(sums[i][j], sums[i][j - 1]);
        }
        if (sums[i][j] == 0) {
          sums[i][j] = sums[i][j - 1];
        }
      }
    }
    return sums[n][squares.size()];
  }
}
