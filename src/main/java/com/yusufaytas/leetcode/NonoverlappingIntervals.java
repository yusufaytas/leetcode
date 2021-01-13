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

import static com.yusufaytas.leetcode.Utils.printMatrix;

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
    Arrays.sort(intervals, Comparator.comparingInt(value -> value[1]));
    int count = 1, min = intervals[0][1];
    printMatrix(intervals);
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= min) {
        count++;
        min = intervals[i][1];
      }
    }
    return intervals.length - count;
  }

  public static void main(String[] args) {
    final int[][] points = {{1, 11}, {2, 12}, {11, 22}, {1, 100}};
    System.out.println(new NonoverlappingIntervals().eraseOverlapIntervals(points));
  }
}
