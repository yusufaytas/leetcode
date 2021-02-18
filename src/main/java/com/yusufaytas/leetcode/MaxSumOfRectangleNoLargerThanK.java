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
Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle
in the matrix such that its sum is no larger than k.

Example:

Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2
Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
             and 2 is the max number no larger than k (k = 2).

Note:

    The rectangle inside the matrix must have an area > 0.
    What if the number of rows is much larger than the number of columns?

https://www.techiedelight.com/calculate-sum-elements-sub-matrix-constant-time/
 */
public class MaxSumOfRectangleNoLargerThanK {

  public int maxSumSubmatrix(final int[][] matrix, final int k) {
    final int[][] sums = new int[matrix.length][matrix[0].length];
    sums[0][0] = matrix[0][0];
    for (int i = 1; i < matrix.length; i++) {
      sums[i][0] = matrix[i][0] + sums[i - 1][0];
    }
    for (int i = 1; i < matrix[0].length; i++) {
      sums[0][i] = matrix[0][i] + sums[0][i - 1];
    }
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i][j];
      }
    }
    int closest = matrix[0][0];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        for (int l = i; l < matrix.length; l++) {
          for (int m = j; m < matrix[0].length; m++) {
            final int sum = sums[l][m]
                - (j > 0 ? sums[l][j - 1] : 0)
                - (i > 0 ? sums[i - 1][m] : 0) +
                (i > 0 && j > 0 ? sums[i - 1][j - 1] : 0);
            if (k >= sum && (k - sum < k - closest || closest > k)) {
              closest = sum;
            }
          }
        }
      }
    }
    return closest;
  }

  public static void main(String[] args) {
    final int[][] matrix = {
        {2, 2, -1}
    };
    final int k = 0;
    System.out.println(new MaxSumOfRectangleNoLargerThanK().maxSumSubmatrix(matrix, k));
  }

}
