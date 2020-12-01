package com.yusufaytas.leetcode;

/*
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ['1','1','1','1','0'],
  ['1','1','0','1','0'],
  ['1','1','0','0','0'],
  ['0','0','0','0','0']
]
Output: 1

Example 2:

Input: grid = [
  ['1','1','0','0','0'],
  ['1','1','0','0','0'],
  ['0','0','1','0','0'],
  ['0','0','0','1','1']
]
Output: 3

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {

  public static void main(String[] args) {
    final char[][] grid = new char[][]{
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '1'},
        {'0', '0', '1', '0', '1'},
        {'1', '1', '1', '1', '1'}
    };
    System.out.println(new NumberOfIslands().numIslands(grid));
  }

  public int numIslands(final char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          if (!((i - 1 >= 0 && grid[i - 1][j] == '.') ||
              (i + 1 < grid.length && grid[i + 1][j] == '.') ||
              (j - 1 >= 0 && grid[i][j - 1] == '.') ||
              (j + 1 < grid[0].length && grid[i][j + 1] == '.'))) {
            count++;
          }
          visit(grid, i, j);
        }
      }
    }
    return count;
  }

  private void visit(final char[][] grid, final int i, final int j) {
    if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
      grid[i][j] = '.';
      visit(grid, i - 1, j);
      visit(grid, i + 1, j);
      visit(grid, i, j - 1);
      visit(grid, i, j + 1);
    }
  }

}
