package com.yusufaytas.leetcode;

import java.util.stream.IntStream;

/*
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
 */
public class ZeroOneMatrix {

  public int[][] updateMatrix(int[][] matrix) {
    final int[][] resultMatrix = new int[matrix.length][matrix.length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        resultMatrix[i][j] = matrix[i][j] == 0 ? 0 : -1;
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        findMin(matrix, resultMatrix, i, j);
      }
    }
    return resultMatrix;
  }

  public int findMin(int[][] matrix, int[][] resultMatrix, int i, int j) {
    if (resultMatrix[i][j] == 0) {
      return 0;
    }
    if (resultMatrix[i][j] != -1) {
      return resultMatrix[i][j];
    }
    if (i > 0 && j > 0 && i < matrix.length && j < matrix.length) {
      final int left = findMin(matrix, resultMatrix, i - 1, j);
      final int right = findMin(matrix, resultMatrix, i + 1, j);
      final int up = findMin(matrix, resultMatrix, i, j - 1);
      final int down = findMin(matrix, resultMatrix, i, j + 1);
      resultMatrix[i][j] = IntStream.of(left, right, up, down).min().getAsInt() + 1;
    }
    return Integer.MAX_VALUE;
  }
}
