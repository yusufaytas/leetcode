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
import java.util.Collections;
import java.util.List;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12],
  [13,14,15,16]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {

  public static void main(String[] args) {
    final int[][] matrix = new int[][]{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    System.out.println(new SpiralMatrix().spiralOrder(matrix));
  }

  public List<Integer> spiralOrder(final int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return Collections.emptyList();
    }
    final int spiralSize = matrix.length * matrix[0].length;
    final List<Integer> spiral = new ArrayList<>(spiralSize);
    int i = 0, j = 0, direction = 0, indexIncrement = 0;
    spiral.add(matrix[0][0]);
    while (spiral.size() != spiralSize) {
      if (direction == 0) {
        if (j + 1 < matrix[0].length - indexIncrement) {
          j = j + 1;
        } else {
          direction = 1;
          continue;
        }
      }
      if (direction == 1) {
        if (i + 1 < matrix.length - indexIncrement) {
          i = i + 1;
        } else {
          direction = 2;
          continue;
        }
      }
      if (direction == 2) {
        if (j - 1 >= indexIncrement) {
          j = j - 1;
        } else {
          direction = 3;
          continue;
        }
      }
      if (direction == 3) {
        if (i - 1 > indexIncrement) {
          i = i - 1;
        } else {
          direction = 0;
          indexIncrement++;
          i = indexIncrement;
          j = indexIncrement;
          spiral.add(matrix[i][j]);
          continue;
        }
      }
      spiral.add(matrix[i][j]);
    }
    return spiral;
  }
}
