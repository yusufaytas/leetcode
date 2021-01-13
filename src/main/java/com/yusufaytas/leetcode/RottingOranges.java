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
import java.util.Arrays;
import java.util.List;

/*
In a given grid, each cell can have one of three values:

    the value 0 representing an empty cell;
    the value 1 representing a fresh orange;
    the value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.
If this is impossible, return -1 instead.



Example 1:

Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten,
because rotting only happens 4-directionally.

Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.

 */
public class RottingOranges {

  public int orangesRotting(final int[][] grid) {
    if (grid == null || grid.length == 0) {
      return -1;
    }
    int count = 0;
    while (true) {
      final List<List<Integer>> rottenOranges = new ArrayList<>();
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          if (grid[i][j] == 1 && ((i + 1 < grid.length && grid[i + 1][j] == 2)
              || (i - 1 >= 0 && grid[i - 1][j] == 2)
              || (j + 1 < grid[0].length && grid[i][j + 1] == 2)
              || (j - 1 >= 0 && grid[i][j - 1] == 2))) {
            rottenOranges.add(Arrays.asList(i, j));
          }
        }
      }
      if (rottenOranges.isEmpty()) {
        break;
      }
      for (int i = 0; i < rottenOranges.size(); i++) {
        grid[rottenOranges.get(i).get(0)][rottenOranges.get(i).get(1)] = 2;
      }
      count++;
    }
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          return -1;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    final int[][] grid = {{1}, {2}};
    System.out.println(new RottingOranges().orangesRotting(grid));
  }
}
