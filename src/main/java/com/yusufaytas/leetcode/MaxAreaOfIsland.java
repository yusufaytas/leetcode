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
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
connected 4-directionally (horizontal or vertical.)
You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array.
(If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]

Given the above grid, return 6. Note the answer is not 11,
because the island must be connected 4-directionally.

Example 2:

[[0,0,0,0,0,0,0,0]]

Given the above grid, return 0.

Note: The length of each dimension in the given grid does not exceed 50.

 */
public class MaxAreaOfIsland {

  public int maxAreaOfIsland(final int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int max = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          max = Math.max(max, maxAreaOfIsland(grid, i, j));
        }
      }
    }
    return max;
  }

  public int maxAreaOfIsland(final int[][] grid, final int i, final int j) {
    if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] != 1) {
      return 0;
    }
    grid[i][j] = -1;
    return maxAreaOfIsland(grid, i + 1, j) + maxAreaOfIsland(grid, i - 1, j)
        + maxAreaOfIsland(grid, i, j + 1) + maxAreaOfIsland(grid, i, j - 1) + 1;
  }
}
