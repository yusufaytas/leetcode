package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
You have k lists of sorted integers in ascending order.
Find the smallest range that includes at least one number from each of the k lists.

We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.

Example 1:
Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
Output: [20,24]
Explanation:
List 1: [4, 10, 15, 24, 26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].
Note:
The given list may contain duplicates, so ascending order means >= here.
1 <= k <= 3500
-105 <= value of elements <= 105.
For Java users, please note that the input type has been changed to List<List<Integer>>.
And after you reset the code template, you'll see this point.
 */
public class SmallestRange {

  public static void main(String[] args) {
    List<List<Integer>> nums = new ArrayList<>();
    List<Integer> l1 = new ArrayList<>();
    Collections.addAll(l1, -40, -20, 1, 9, 12, 12, 14);
    List<Integer> l2 = new ArrayList<>();
    Collections.addAll(l2, -39, 42, 70, 70, 70, 71, 72, 72, 73);
    List<Integer> l3 = new ArrayList<>();
    Collections.addAll(l3, -2, 6, 11, 12, 12, 13, 15);
    Collections.addAll(nums, l1, l2, l3);
    System.out.println(Arrays.toString(new SmallestRange().smallestRange(nums)));
  }

  public int[] smallestRange(List<List<Integer>> nums) {
    if (nums.size() == 0 || nums.stream().anyMatch(l -> l.isEmpty())) {
      return null;
    }
    int[] indexes = new int[nums.size()];
    int min = 0, max = Integer.MAX_VALUE - 1, currentMax = Integer.MIN_VALUE;
    PriorityQueue<Integer> heap = new PriorityQueue<>(
        Comparator.comparingInt(o -> nums.get(o).get(indexes[o])));
    for (int i = 0; i < nums.size(); i++) {
      heap.add(i);
      if (nums.get(i).get(0) > currentMax) {
        currentMax = nums.get(i).get(0);
      }
    }

    while (true) {
      int currentMinList = heap.poll();
      int currentMin = nums.get(currentMinList).get(indexes[currentMinList]);

      if (currentMax - currentMin < max - min) {
        max = currentMax;
        min = currentMin;
      }

      indexes[currentMinList]++;

      if (indexes[currentMinList] >= nums.get(currentMinList).size()) {
        break;
      }

      if (nums.get(currentMinList).get(indexes[currentMinList]) > currentMax) {
        currentMax = nums.get(currentMinList).get(indexes[currentMinList]);
      }
      heap.add(currentMinList);
    }
    return new int[]{max, min};
  }
}
