package com.yusufaytas.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class KClosestPointsToOrigin {

  public int[][] kClosest(final int[][] points, final int K) {
    Arrays.sort(points, Comparator.comparingDouble(o -> -Math.pow(o[0], 2) + Math.pow(o[1], 2)));
    return Arrays.copyOf(points,  K);
  }
}
