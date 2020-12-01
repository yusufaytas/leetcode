package com.yusufaytas.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      int remaining = target - nums[i];
      if (numMap.containsKey(remaining) && numMap.get(remaining) != i) {
        return new int[]{i, numMap.get(remaining)};
      }
      numMap.put(nums[i], i);
    }
    throw new IllegalArgumentException("At least a solution is needed.");
  }

}
