package com.yusufaytas.leetcode;

import static com.yusufaytas.leetcode.Utils.printArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.
The right interval for an interval i is an interval j such that startj >= endi and startj is minimized.
Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.

Example 1:

Input: intervals = [[1,2]]
Output: [-1]
Explanation: There is only one interval in the collection, so it outputs -1.

Example 2:

Input: intervals = [[3,4],[2,3],[1,2]]
Output: [-1,0,1]
Explanation: There is no right interval for [3,4].
The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.

Example 3:

Input: intervals = [[1,4],[2,3],[3,4]]
Output: [-1,2,-1]
Explanation: There is no right interval for [1,4] and [3,4].
The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.

 */
public class FindRightInterval {

  public int[] findRightInterval(final int[][] intervals) {
    final List<int[]> sortedIntervals = new ArrayList<>(intervals.length);
    for (int i = 0; i < intervals.length; i++) {
      final int[] interval = new int[3];
      interval[0] = intervals[i][0];
      interval[1] = intervals[i][1];
      interval[2] = i;
      sortedIntervals.add(interval);
    }
    final Comparator<int[]> comparator = Comparator.comparingInt(value -> value[0]);
    Collections.sort(sortedIntervals, comparator);
    final int[] rightIntervals = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      final int[] right = new int[1];
      right[0] = intervals[i][1];
      final int index = Collections.binarySearch(sortedIntervals, right, comparator);
      rightIntervals[i] =
          index < 0 ? (Math.abs(index + 1) < intervals.length ? sortedIntervals
              .get(Math.abs(index + 1))[2] : -1)
              : sortedIntervals.get(index)[2];
    }
    return rightIntervals;
  }

  public static void main(String[] args) {
    int[][] intervals = {
        {4, 5}, {2, 3}, {1, 2}
    };
    final int[] array = new FindRightInterval().findRightInterval(intervals);
    printArray(array);
  }
}
