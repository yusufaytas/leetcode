package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> all = new ArrayList<List<Integer>>();
    for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < nums.length && nums[i] + nums[j] <= 0; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        int k = j + 1;
        while (k < nums.length && 0 > nums[i] + nums[j] + nums[k]) {
          k++;
        }
        if (k < nums.length && nums[i] + nums[j] + nums[k] == 0) {
          all.add(Arrays.asList(nums[i], nums[j], nums[k]));
        }
      }
    }
    return all;
  }

}
