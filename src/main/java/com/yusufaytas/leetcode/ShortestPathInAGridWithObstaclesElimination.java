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

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/*
Given a m * n grid, where each cell is either 0 (empty) or 1 (obstacle).
In one step, you can move up, down, left or right from and to an empty cell.

Return the minimum number of steps to walk from the upper left corner (0, 0)
to the lower right corner (m-1, n-1) given that you can eliminate at most k obstacles.
If it is not possible to find such walk return -1.

Example 1:

Input:
grid =
[[0,0,0},
 [1,1,0},
 [0,0,0},
 [0,1,1},
 [0,0,0]},
k = 1
Output: 6
Explanation:
The shortest path without eliminating any obstacle is 10.
The shortest path with one obstacle elimination at position (3,2) is 6.
Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).



Example 2:

Input:
grid =
[[0,1,1},
 [1,1,1},
 [1,0,0]},
k = 1
Output: -1
Explanation:
We need to eliminate at least two obstacles to find such a walk.

 */
public class ShortestPathInAGridWithObstaclesElimination {

  public int shortestPath(final int[][] grid, final int k) {
    final int[][][] visited = new int[grid.length][grid[0].length][k + 1];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        Arrays.fill(visited[i][j], -1);
      }
    }
    final int shortest = shortestPath(grid, visited, 0, 0, k);
    return shortest == -2 ? -1 : shortest;
  }

  public int shortestPath(final int[][] grid, final int[][][] visited,
      final int i, final int j, final int k) {
    if (i == grid.length - 1 && j == grid[0].length - 1) {
      return 0;
    }
    if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 1 && k == 0) {
      return -2;
    }
    if (visited[i][j][k] != -1) {
      return visited[i][j][k];
    }
    visited[i][j][k] = -2;
    final Optional<Integer> min = Stream
        .of(shortestPath(grid, visited, i + 1, j, grid[i][j] == 1 ? k - 1 : k),
            shortestPath(grid, visited, i, j + 1, grid[i][j] == 1 ? k - 1 : k),
            shortestPath(grid, visited, i - 1, j, grid[i][j] == 1 ? k - 1 : k),
            shortestPath(grid, visited, i, j - 1, grid[i][j] == 1 ? k - 1 : k))
        .filter(o -> o >= 0)
        .sorted()
        .findFirst();
    if (min.isPresent()) {
      visited[i][j][k] = min.get() + 1;
    }
    return visited[i][j][k];
  }

  public static void main(String[] args) {
    final int[][] grid = {
        {0, 0},
        {1, 0},
        {1, 0},
        {1, 0},
        {1, 0},
        {1, 0},
        {0, 0},
        {0, 1},
        {0, 1},
        {0, 1},
        {0, 0},
        {1, 0},
        {1, 0},
        {0, 0}};
    final int k = 4;
    System.out.println(new ShortestPathInAGridWithObstaclesElimination().shortestPath(grid, k));
  }
}
