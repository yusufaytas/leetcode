package com.yusufaytas.leetcode;

/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ['1','0','1','0','0'],
  ['1','0','1','1','1'],
  ['1','1','1','1','1'],
  ['1','0','0','1','0']
]
Output: 6

 */
public class MaximalRectangle {

  public static void main(String args[]) {
    final char[][] matrix = {
        {'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}
    };
    System.out.println(new MaximalRectangle().maximalRectangle(matrix));
  }

  public int maximalRectangle(final char[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    final int[][] height = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        final int val = matrix[i][j] == '1' ? 1 : 0;
        if (i > 0 && val != 0) {
          height[i][j] = height[i - 1][j] + 1;
        } else {
          height[i][j] = val;
        }
      }
    }
    //find max average
    int max = 0;
    for (int i = 0; i < height.length; i++) {
      for (int j = 0; j < height[0].length; j++) {
        int maxAvg = height[i][j];
        max = Math.max(max, maxAvg);
        for (int k = j + 1; k < height[0].length; k++) {
          if (height[i][k] == 0) {
            break;
          }
          maxAvg = Math.min(maxAvg, height[i][k]);
          max = Math.max(max, maxAvg * (k - j + 1));
        }
      }
    }
    return max;
  }
}
