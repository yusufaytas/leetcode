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

import java.util.HashSet;
import java.util.Set;

/*
Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

Follow up:

    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?
 */
public class SetMatrixZeroes {

  public void setZeroes(final int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }
    final Set<Integer> zeroColumns = new HashSet<>();
    final Set<Integer> zeroRows = new HashSet<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          zeroColumns.add(j);
          zeroRows.add(i);
        }
      }
    }
    for (final int i : zeroRows) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[i][j] = 0;
      }
    }
    for (final int j : zeroColumns) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][j] = 0;
      }
    }
  }

}
