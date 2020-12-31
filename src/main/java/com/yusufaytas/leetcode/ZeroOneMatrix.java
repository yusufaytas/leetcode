package com.yusufaytas.leetcode;

import static com.yusufaytas.leetcode.Utils.printMatrix;

import java.util.LinkedList;
import java.util.List;

/*
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
Example 1:

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Example 2:

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]

 */
public class ZeroOneMatrix {

  public int[][] updateMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return new int[][]{};
    }
    final List<int[]> coordinates = new LinkedList<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] != 0 &&
            (i == 0 || matrix[i - 1][j] != 0) &&
            (i == matrix.length - 1 || matrix[i + 1][j] != 0) &&
            (j == 0 || matrix[i][j - 1] != 0) &&
            (j == matrix[0].length - 1 || matrix[i][j + 1] != 0)) {
          matrix[i][j] = Integer.MAX_VALUE;
          coordinates.add(new int[]{i, j});
        }
      }
    }
    int n = 1;
    while (!coordinates.isEmpty()) {
      final int size = coordinates.size();
      for (int k = 0; k < size; k++) {
        final int[] coordinate = coordinates.remove(0);
        final int i = coordinate[0];
        final int j = coordinate[1];
        if ((i > 0 && matrix[i - 1][j] == n) ||
            (i < matrix.length - 2 && matrix[i + 1][j] == n) ||
            (j > 0 && matrix[i][j - 1] == n) ||
            (j < matrix[0].length - 2 && matrix[i][j + 1] == n)) {
          matrix[i][j] = n + 1;
          continue;
        }
        coordinates.add(coordinate);
      }
      n++;
    }
    return matrix;
  }

  public static void main(String[] args) {
    final int[][] matrix = {
        {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
        {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
        {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
        {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
        {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
        {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
        {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
        {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}
    };
    final int[][] result = new ZeroOneMatrix().updateMatrix(matrix);
    printMatrix(result);
  }
}
