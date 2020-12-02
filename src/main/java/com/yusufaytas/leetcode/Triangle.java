package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a triangle, find the minimum path sum from top to bottom.
Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space,
where n is the total number of rows in the triangle.

 */
public class Triangle {

  public int minimumTotal(final List<List<Integer>> triangle) {
    if (triangle == null || triangle.isEmpty()) {
      return -1;
    }
    final int[][] minValues = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
    return minimumTotal(triangle, 0, 0, minValues);
  }

  public int minimumTotal(final List<List<Integer>> triangle, int level, int index,
      final int[][] minValues) {
    if (index < 0 || index == triangle.get(level).size()) {
      return Integer.MAX_VALUE;
    }
    if (level == triangle.size() - 1) {
      return triangle.get(level).get(index);
    }
    if (minValues[level][index] != 0) {
      return minValues[level][index];
    }
    minValues[level][index] = triangle.get(level).get(index) +
        Math.min(minimumTotal(triangle, level + 1, index, minValues),
            minimumTotal(triangle, level + 1, index + 1, minValues));
    return minValues[level][index];
  }

  public static void main(String[] args) {
    final List<List<Integer>> triangle = new ArrayList<>();
    triangle.add(Arrays.asList(2));
    triangle.add(Arrays.asList(3, 4));
    triangle.add(Arrays.asList(6, 5, 7));
    triangle.add(Arrays.asList(4, 1, 8, 3));
    System.out.println(new Triangle().minimumTotal(triangle));
  }
}
