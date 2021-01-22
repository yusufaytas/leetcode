package com.yusufaytas.leetcode;

import java.util.stream.IntStream;

/*
A conveyor belt has packages that must be shipped from one port to another within D days.

The i-th package on the conveyor belt has a weight of weights[i].
Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in
all the packages on the conveyor belt being shipped within D days.


Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
Output: 15
Explanation:
A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity
14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

Example 2:

Input: weights = [3,2,2,4,1,4], D = 3
Output: 6
Explanation:
A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4

Example 3:

Input: weights = [1,2,3,1,1], D = 4
Output: 3
Explanation:
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1

TODO: revisit
 */
public class CapacityToShipPackagesWithinDDays {

  public int shipWithinDays(final int[] weights, final int D) {
    int start = IntStream.of(weights).max().getAsInt();
    int end = IntStream.of(weights).sum();
    while (start < end) {
      final int mid = (end + start) / 2;
      final int days = minDays(weights, mid);
      if (days > D) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }
    return end;
  }

  private int minDays(final int[] weights, final int mid) {
    int count = 1, sum = 0;
    for (int i = 0; i < weights.length; i++) {
      if (sum + weights[i] > mid) {
        count++;
        sum = 0;
      }
      sum += weights[i];
    }
    return count;
  }

  public static void main(String[] args) {
    final int[] weights = {1,2,3,4,5,6,7,8,9,10};
    final int D = 5;
    System.out.println(new CapacityToShipPackagesWithinDDays().shipWithinDays(weights, D));
  }
}
