package com.yusufaytas.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
Given a collection of intervals, find the minimum number of intervals
you need to remove to make the rest of the intervals non-overlapping.

Example 1:

Input: [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.

Example 2:

Input: [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.

Example 3:

Input: [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

Note:
    You may assume the interval's end point is always bigger than its start point.
    Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 */
public class NonoverlappingIntervals {

  public int eraseOverlapIntervals(final int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }
    Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));
    int max = 0;
    final int[] maxNonoverlapping = new int[intervals.length];
    Arrays.fill(maxNonoverlapping, 1);
    for (int i = 1; i < intervals.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (intervals[j][1] <= intervals[i][0]) {
          maxNonoverlapping[i] = Math.max(maxNonoverlapping[i], maxNonoverlapping[j] + 1);
          max = Math.max(max, maxNonoverlapping[i]);
        }
      }
    }
    return intervals.length - max;
  }

  public static void main(String[] args) {
    final int[][] points = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
    System.out.println(new NonoverlappingIntervals().eraseOverlapIntervals(points));
  }
}
