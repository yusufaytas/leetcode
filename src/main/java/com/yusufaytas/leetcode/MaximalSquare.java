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
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
 */
public class MaximalSquare {

  public int getMax(int i, int j, char[][] matrix) {
    if (matrix[i][j] != '1') {
      return 0;
    }
    int max = 0;
    int currentI = i, currentJ = j;
    while (currentI < matrix.length && currentJ < matrix[i].length) {
      if (isSquare(i, j, currentI, currentJ, matrix)) {
        max++;
      }
      currentI++;
      currentJ++;
    }
    return max;
  }

  private boolean isSquare(int lowI, int lowJ, int highI, int highJ, char[][] matrix) {
    for (int i = lowI; i <= highI; i++) {
      for (int j = lowJ; j <= highJ; j++) {
        if (matrix[i][j] != '1') {
          return false;
        }
      }
    }
    return true;
  }

  public int maximalSquare(char[][] matrix) {
    int max = 0;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        int currentMax = getMax(i, j, matrix);
        if (max < currentMax) {
          max = currentMax;
        }
      }
    }
    return max * max;
  }

}
