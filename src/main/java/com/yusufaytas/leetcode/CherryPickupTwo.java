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

/*
Given a rows x cols matrix grid representing a field of cherries.
Each cell in grid represents the number of cherries that you can collect.

You have two robots that can collect cherries for you,
 Robot #1 is located at the top-left corner (0,0) ,
 and Robot #2 is located at the top-right corner (0, cols-1) of the grid.

Return the maximum number of cherries collection using both robots  by following the rules below:

    From a cell (i,j), robots can move to cell (i+1, j-1) , (i+1, j) or (i+1, j+1).
    When any robot is passing through a cell, It picks it up all cherries, and the cell becomes an empty cell (0).
    When both robots stay on the same cell, only one of them takes the cherries.
    Both robots cannot move outside of the grid at any moment.
    Both robots should reach the bottom row in the grid.

 */
public class CherryPickupTwo {

  public int cherryPickup(final int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    final int[][][] maxCherries = new int[grid.length][grid[0].length][grid[0].length];
    for (int i = 0; i < maxCherries.length; i++) {
      for (int j = 0; j < maxCherries[0].length; j++) {
        Arrays.fill(maxCherries[i][j], -1);
      }
    }
    maxCherries[0][0][grid[0].length - 1] =
        grid[0][0] + (grid[0].length > 1 ? grid[0][grid[0].length - 1] : 0);
    int max = maxCherries[0][0][grid[0].length - 1];
    for (int i = 1; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {//first robot
        for (int k = 0; k < grid[0].length; k++) {//second robot
          //[j,k], [j, k-1], [j, k+1], [j-1, k], [j-1, k-1], [j-1, k+1], [j+1, k], [j+1, k-1], [j+1, k+1]
          int prev = Math.max(-1, maxCherries[i - 1][j][k]);
          prev = Math.max(prev, (k > 0 ? maxCherries[i - 1][j][k - 1] : -1));
          prev = Math.max(prev, (k < grid[0].length - 1 ? maxCherries[i - 1][j][k + 1] : -1));
          if (j > 0) {
            prev = Math.max(prev, maxCherries[i - 1][j - 1][k]);
            prev = Math.max(prev, (k > 0 ? maxCherries[i - 1][j - 1][k - 1] : -1));
            prev = Math
                .max(prev, (k < grid[0].length - 1 ? maxCherries[i - 1][j - 1][k + 1] : -1));
          }
          if (j < grid[0].length - 1) {
            prev = Math.max(prev, maxCherries[i - 1][j + 1][k]);
            prev = Math.max(prev, (k > 0 ? maxCherries[i - 1][j + 1][k - 1] : -1));
            prev = Math.max(prev, (k < grid[0].length - 1 ? maxCherries[i - 1][j + 1][k + 1] : -1));
          }
          maxCherries[i][j][k] =
              prev == -1 ? -1 : prev + (j == k ? grid[i][j] : grid[i][j] + grid[i][k]);
          max = Math.max(max, maxCherries[i][j][k]);
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    final int[][] grid = {{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};
    System.out.println(new CherryPickupTwo().cherryPickup(grid));
  }
}
