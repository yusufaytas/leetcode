package com.yusufaytas.leetcode;

/*
Given a m x n grid. Each cell of the grid represents a street. The street of grid[i][j] can be:

    1 which means a street connecting the left cell and the right cell.
    2 which means a street connecting the upper cell and the lower cell.
    3 which means a street connecting the left cell and the lower cell.
    4 which means a street connecting the right cell and the lower cell.
    5 which means a street connecting the left cell and the upper cell.
    6 which means a street connecting the right cell and the upper cell.

You will initially start at the street of the upper-left cell (0,0).
A valid path in the grid is a path which starts from the upper left cell (0,0)
and ends at the bottom-right cell (m - 1, n - 1). The path should only follow the streets.

Notice that you are not allowed to change any street.

Return true if there is a valid path in the grid or false otherwise.
 */
public class CheckIfThereIsAValidPathInAGrid {

  public boolean hasValidPath(final int[][] grid) {
    if (grid == null || grid.length == 0) {
      return false;
    }
    final boolean[][] visited = new boolean[grid.length][grid[0].length];
    return hasValidPath(grid, visited, 0, 0);
  }

  public boolean hasValidPath(final int[][] grid, final boolean[][] visited,
      final int i, final int j) {
    if (visited[i][j]) {
      return false;
    }
    if (i == grid.length - 1 && j == grid[0].length - 1) {
      return true;
    }
    visited[i][j] = true;
    final boolean hasValid =
        (canConnect(grid, i, j, i + 1, j) && hasValidPath(grid, visited, i + 1, j))
            || (canConnect(grid, i, j, i, j + 1) && hasValidPath(grid, visited, i, j + 1))
            || (canConnect(grid, i, j, i - 1, j) && hasValidPath(grid, visited, i - 1, j))
            || (canConnect(grid, i, j, i, j - 1) && hasValidPath(grid, visited, i, j - 1));
    visited[i][j] = false;
    return hasValid;
  }

  private boolean canConnect(final int[][] grid, final int i, final int j,
      final int nextI, final int nextJ) {
    if (nextI == grid.length || nextI < 0) {
      return false;
    }
    if (nextJ == grid[0].length || nextJ < 0) {
      return false;
    }
    if (grid[i][j] == 1) {
      if (nextJ > j) {
        return grid[nextI][nextJ] == 1 || grid[nextI][nextJ] == 3 || grid[nextI][nextJ] == 5;
      }
      if (nextJ < j) {
        return grid[nextI][nextJ] == 1 || grid[nextI][nextJ] == 4 || grid[nextI][nextJ] == 6;
      }
    }
    if (grid[i][j] == 2) {
      if (nextI > i) {
        return grid[nextI][nextJ] == 2 || grid[nextI][nextJ] == 5 || grid[nextI][nextJ] == 6;
      }
      if (nextI < i) {
        return grid[nextI][nextJ] == 2 || grid[nextI][nextJ] == 3 || grid[nextI][nextJ] == 4;
      }
    }
    if (grid[i][j] == 3) {
      if (nextI > i) {
        return grid[nextI][nextJ] == 2 || grid[nextI][nextJ] == 5 || grid[nextI][nextJ] == 6;
      }
      if (nextJ < j) {
        return grid[nextI][nextJ] == 1 || grid[nextI][nextJ] == 4 || grid[nextI][nextJ] == 6;
      }
    }
    if (grid[i][j] == 4) {
      if (nextI > i) {
        return grid[nextI][nextJ] == 2 || grid[nextI][nextJ] == 5 || grid[nextI][nextJ] == 6;
      }
      if (nextJ > j) {
        return grid[nextI][nextJ] == 1 || grid[nextI][nextJ] == 3 || grid[nextI][nextJ] == 5;
      }
    }
    if (grid[i][j] == 5) {
      if (nextI < i) {
        return grid[nextI][nextJ] == 3 || grid[nextI][nextJ] == 2 || grid[nextI][nextJ] == 4;
      }
      if (nextJ < j) {
        return grid[nextI][nextJ] == 1 || grid[nextI][nextJ] == 4 || grid[nextI][nextJ] == 6;
      }
    }
    if (grid[i][j] == 6) {
      if (nextI < i) {
        return grid[nextI][nextJ] == 2 || grid[nextI][nextJ] == 3 || grid[nextI][nextJ] == 4;
      }
      if (nextJ > j) {
        return grid[nextI][nextJ] == 1 || grid[nextI][nextJ] == 3 || grid[nextI][nextJ] == 5;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    final int[][] grid = {
        {2, 4, 3}, {6, 5, 2}
    };
    System.out.println(new CheckIfThereIsAValidPathInAGrid().hasValidPath(grid));
  }
}
