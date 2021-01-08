package com.yusufaytas.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
There are some spherical balloons spread in two-dimensional space. For each balloon,
provided input is the start and end coordinates of the horizontal diameter.
Since it's horizontal, y-coordinates don't matter, and hence the x-coordinates of start
and end of the diameter suffice. The start is always smaller than the end.

An arrow can be shot up exactly vertically from different points along the x-axis.
A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend.
There is no limit to the number of arrows that can be shot. An arrow once shot
keeps traveling up infinitely.

Given an array points where points[i] = [xstart, xend], return the minimum number
of arrows that must be shot to burst all balloons.

Example 1:

Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: One way is to shoot one arrow for example at x = 6
(bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).

Example 2:

Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4

Example 3:

Input: points = [[1,2],[2,3],[3,4],[4,5]]
Output: 2

Example 4:

Input: points = [[1,2]]
Output: 1

Example 5:

Input: points = [[2,3],[2,3]]
Output: 1

 */
public class MinimumNumberOfArrowsToBurstBalloons {

  public int findMinArrowShots(final int[][] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    final Comparator<int[]> comparator = (o1, o2) -> o1[0] == o2[0]
        ? Integer.compare(o1[1], o2[1])
        : Integer.compare(o1[0], o2[0]);
    Arrays.sort(points, comparator);
    int count = 0;
    int index = 0;
    while (index < points.length) {
      int maxFinishIndex = index, nextIndex = index;
      final int searchIndex = Arrays
          .binarySearch(points, new int[]{points[maxFinishIndex][1], Integer.MAX_VALUE},
              comparator);
      final int endIndex = Math
          .min(searchIndex >= 0 ? searchIndex : Math.abs(searchIndex + 1), points.length - 1);
      for (int i = index; i <= endIndex; i++) {
        if (points[i][0] > points[maxFinishIndex][1]) {
          break;
        }
        nextIndex = i;
        if (points[i][1] < points[maxFinishIndex][1]) {
          maxFinishIndex = i;
        }
      }
      index = nextIndex + 1;
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    final int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
    System.out.println(new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(points));
  }
}
