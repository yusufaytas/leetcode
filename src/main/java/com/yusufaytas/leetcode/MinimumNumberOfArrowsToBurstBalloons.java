/**
 * Copyright © 2021 Yusuf Aytas. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
    final Comparator<int[]> comparator = Comparator.comparingInt(value -> value[0]);
    Arrays.sort(points, comparator);
    int count = 1, minEnd = points[0][1];
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] > minEnd) {
        count++;
        minEnd = points[i][1];
      } else {
        minEnd = Math.min(minEnd, points[i][1]);
      }
    }
    return count;
  }

  public static void main(String[] args) {
    final int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
    System.out.println(new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(points));
  }
}
