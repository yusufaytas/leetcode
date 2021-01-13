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
Given a n x n matrix where each of the rows and columns are sorted in ascending order,
find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  3,  5, 16],
   [2, 11, 13, 17],
   [3, 13, 15, 19],
   [4, 14, 16, 21]
],
k = 8

Note:
You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class KthSmallestElementInSortedMatrix {

  public static void main(String[] args) {
    final int[][] matrix = {
        {1, 3, 5, 16},
        {2, 11, 13, 17},
        {3, 13, 15, 19},
        {4, 14, 16, 21}
    };
    System.out.println(new KthSmallestElementInSortedMatrix().kthSmallest(matrix, 10));
  }

  public int kthSmallest(final int[][] matrix, final int k) {
    if (matrix == null || matrix.length == 0) {
      return -1;
    }
    int count = 0, element = matrix[0][0];
    while (count < k) {
      int i = 0, j = 0;
      element = matrix[i][j];
      while (i < matrix.length && j < matrix.length) {
        final int left = i + 1 < matrix.length ? matrix[i + 1][j] : Integer.MAX_VALUE;
        final int right = j + 1 < matrix.length ? matrix[i][j + 1] : Integer.MAX_VALUE;
        if (left > right) {
          matrix[i][j] = right;
          j++;
        } else {
          matrix[i][j] = left;
          i++;
        }
      }
      count++;
    }
    return element;
  }
}
