package com.yusufaytas.leetcode;

import static com.yusufaytas.leetcode.Utils.printMatrix;

import java.util.ArrayList;
import java.util.List;

/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

Example 3:

Input: intervals = [], newInterval = [5,7]
Output: [[5,7]]

Example 4:

Input: intervals = [[1,5]], newInterval = [2,3]
Output: [[1,5]]

Example 5:

Input: intervals = [[1,5]], newInterval = [2,7]
Output: [[1,7]]

 */
public class InsertInterval {

  public int[][] insert(final int[][] intervals, final int[] newInterval) {
    if (intervals == null || intervals.length == 0) {
      return new int[][]{newInterval};
    }
    final List<int[]> newIntervals = new ArrayList<>();
    for (int i = 0; i < intervals.length; i++) {
      if (intervals[i][1] < newInterval[0] || intervals[i][0] > newInterval[1]) {
        newIntervals.add(intervals[i]);
        if (intervals[i][1] < newInterval[0] && i + 1 < intervals.length
            && intervals[i + 1][0] > newInterval[1]) {
          newIntervals.add(newInterval);
        }
        continue;
      }
      int min = newInterval[0], max = newInterval[1];
      while (i < intervals.length) {
        if (intervals[i][0] > newInterval[1]) {
          i--;
          break;
        }
        max = Math.max(max, intervals[i][1]);
        min = Math.min(min, intervals[i][0]);
        i++;
      }
      newIntervals.add(new int[]{min, max});
    }
    if (intervals[0][0] > newInterval[1]) {
      newIntervals.add(0, newInterval);
    }
    if (intervals[intervals.length - 1][1] < newInterval[0]) {
      newIntervals.add(newInterval);
    }
    final int[][] mergedIntervals = new int[newIntervals.size()][2];
    for (int i = 0; i < newIntervals.size(); i++) {
      mergedIntervals[i] = newIntervals.get(i);
    }
    return mergedIntervals;
  }

  public static void main(String[] args) {
    final int[][] intervals = {{3, 5}};
    final int[] newInterval = {1, 1};
    final int[][] mergedIntervals = new InsertInterval().insert(intervals, newInterval);
    printMatrix(mergedIntervals);
  }
}
