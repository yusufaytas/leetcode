package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    int end = 0;
    for (int i = 0; i < buildings.length; i++) {
      if (buildings[i][1] > end) {
        end = buildings[i][1];
      }
    }
    final int[] maxHeights = new int[end + 1];
    for (int i = 0; i < buildings.length; i++) {
      for (int j = buildings[i][0]; j < buildings[i][1]; j++) {
        if (buildings[i][2] > maxHeights[j]) {
          maxHeights[j] = buildings[i][2];
        }
      }
    }
    final List<List<Integer>> points = new ArrayList<>();
    int prev = 0;
    for (int i = 0; i < maxHeights.length; i++) {
      if (maxHeights[i] != prev) {
        points.add(Arrays.asList(i, maxHeights[i]));
      }
      prev = maxHeights[i];
    }
    return points;
  }

  public static void main(String[] args) {
    final int[][] buildings = {{0, 2, 3}, {2, 5, 3}};
    System.out.println(new SkylineProblem().getSkyline(buildings));
  }
}
