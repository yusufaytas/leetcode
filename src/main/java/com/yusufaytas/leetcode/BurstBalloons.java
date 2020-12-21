package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it
represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[left] * nums[i] * nums[right] coins. Here left
and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Return the maximum coins you can collect by bursting the balloons wisely.

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167

Example 2:

Input: nums = [1,5]
Output: 10

 */
public class BurstBalloons {

  public int maxCoins(final int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    final List<Integer> remainingIndexes = IntStream.range(0, nums.length).boxed()
        .collect(Collectors.toCollection(LinkedList::new));
    final Map<List<Integer>, Integer> visited = new HashMap<>();
    return maxCoins(nums, remainingIndexes, visited);
  }

  public int maxCoins(final int[] nums, final List<Integer> remainingIndexes,
      final Map<List<Integer>, Integer> visited) {
    if (remainingIndexes.size() == 1) {
      return nums[remainingIndexes.get(0)];
    }
    if (visited.containsKey(remainingIndexes)) {
      return visited.get(remainingIndexes);
    }
    int max = 0;
    for (int i = 0; i < remainingIndexes.size(); i++) {
      final int left = i > 0 ? nums[remainingIndexes.get(i - 1)] : 1;
      final int right = i + 1 < remainingIndexes.size() ? nums[remainingIndexes.get(i + 1)] : 1;
      final int value = left * right * nums[remainingIndexes.get(i)];
      final int index = remainingIndexes.remove(i);
      max = Math.max(value + maxCoins(nums, remainingIndexes, visited), max);
      remainingIndexes.add(i, index);
    }
    visited.put(new ArrayList<>(remainingIndexes), max);
    return max;
  }

  public static void main(String[] args) {
    final int[] nums = {8, 2, 6, 8, 9, 8, 1, 4, 1, 5, 3, 0, 7, 7, 0, 4, 2, 2, 5};
    System.out.println(new BurstBalloons().maxCoins(nums));
  }
}
