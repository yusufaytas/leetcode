package com.yusufaytas.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

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
    final Comparator<int[]> comparator = Comparator.comparingInt(value -> value[0]);
    Arrays.sort(points, comparator);
    final Map<Integer, Set<Integer>> intersections = new HashMap<>();
    final TreeMap<Integer, Set<Integer>> balloons = new TreeMap<>();
    for (int i = 0; i < points.length; i++) {
      intersections.put(points[i][0], new HashSet<>());
      intersections.put(points[i][1], new HashSet<>());
      balloons.put(i, new HashSet<>());
    }
    for (final int key : intersections.keySet()) {
      for (int i = 0; i < points.length; i++) {
        if (key <= points[i][1] && key >= points[i][0]) {
          intersections.get(key).add(i);
          balloons.get(i).add(key);
        }
      }
    }
    int count = 0;
    while (!balloons.isEmpty()) {
      final Entry<Integer, Set<Integer>> e = balloons.firstEntry();
      final int maxIntersecting = e.getValue().stream()
          .max(Comparator.comparingInt(v -> intersections.get(v).size()))
          .get();
      for (final int balloon : intersections.get(maxIntersecting).stream()
          .collect(Collectors.toList())) {
        for (final int intersection : balloons.get(balloon)) {
          intersections.get(intersection).remove(balloon);
        }
        balloons.remove(balloon);
      }
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    final int[][] points = {{9, 17}, {4, 12}, {4, 8}, {4, 8}, {7, 13}, {3, 4}, {7, 12}, {9, 15}};
    System.out.println(new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(points));
  }
}
