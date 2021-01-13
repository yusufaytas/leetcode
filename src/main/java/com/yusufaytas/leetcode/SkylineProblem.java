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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/*
A city's skyline is the outer contour of the silhouette formed by all the buildings
in that city when viewed from a distance. Given the locations and heights of all the buildings,
return the skyline formed by these buildings collectively.

The geometric information of each building is given in the array buildings where
buildings[i] = [lefti, righti, heighti]:

    lefti is the x coordinate of the left edge of the ith building.
    righti is the x coordinate of the right edge of the ith building.
    heighti is the height of the ith building.

You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

The skyline should be represented as a list of "key points" sorted by their x-coordinate
in the form [[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal
segment in the skyline except the last point in the list, which always has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost building ends. Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.

Note: There must be no consecutive horizontal lines of equal height in the output skyline.
For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable; the three lines of
height 5 should be merged into one in the final output as such: [...,[2 3],[4 5],[12 7],...]

Example 1:

Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
Explanation:
Figure A shows the buildings of the input.
Figure B shows the skyline formed by those buildings.
The red points in figure B represent the key points in the output list.

Example 2:

Input: buildings = [[0,2,3],[2,5,3]]
Output: [[0,3],[5,0]]

 */
public class SkylineProblem {

  public List<List<Integer>> getSkyline(final int[][] buildings) {
    if (buildings == null || buildings.length == 0) {
      return Collections.emptyList();
    }
    final Comparator<int[]> comparator = Comparator.comparingInt(value -> value[0]);
    Arrays.sort(buildings, comparator);
    final Map<Integer, Integer> intersections = new HashMap<>();
    for (int i = 0; i < buildings.length; i++) {
      if (intersections.getOrDefault(buildings[i][0], 0) < buildings[i][2]) {
        intersections.put(buildings[i][0], buildings[i][2]);
      }
      if (!intersections.containsKey(buildings[i][1])) {
        intersections.put(buildings[i][1], 0);
      }
    }
    for (final int key : intersections.keySet()) {
      final int searchIndex = Arrays.binarySearch(buildings, new int[]{0, key}, comparator);
      final int startIndex =
          searchIndex < 0 ? Math.min(Math.abs(searchIndex + 1), buildings.length) : searchIndex;
      for (int i = startIndex; i < buildings.length; i++) {
        if (key < buildings[i][0]) {
          break;
        }
        if (key >= buildings[i][0] && key < buildings[i][1]) {
          intersections.put(key, Math.max(intersections.get(key), buildings[i][2]));
        }
      }
    }
    final List<List<Integer>> points = new ArrayList<>();
    int prev = 0;
    for (final Entry<Integer, Integer> entry : intersections.entrySet().stream()
        .sorted(Comparator.comparingInt(Entry::getKey)).collect(Collectors.toList())) {
      if (entry.getValue() != prev) {
        points.add(Arrays.asList(entry.getKey(), entry.getValue()));
      }
      prev = entry.getValue();
    }
    return points;
  }

  public static void main(String[] args) {
    final int[][] buildings = {{0, 2, 3}, {2, 5, 3}};
    System.out.println(new SkylineProblem().getSkyline(buildings));
  }
}
