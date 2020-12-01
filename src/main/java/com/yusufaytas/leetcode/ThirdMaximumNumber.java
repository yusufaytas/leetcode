package com.yusufaytas.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ThirdMaximumNumber {

  public static void main(String[] args) {
    final int[] nums = {3, 2, 1};
    System.out.println(new ThirdMaximumNumber().thirdMax(nums));
  }

  public int thirdMax(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
    final Set<Integer> seen = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (!seen.add(nums[i])) {
        continue;
      }
      if (nums[i] > first) {
        third = second;
        second = first;
        first = nums[i];
      } else if (nums[i] > second) {
        third = second;
        second = nums[i];
      } else if (nums[i] > third) {
        third = nums[i];
      }
    }
    if (seen.size() < 3) {
      return first;
    }
    return third;
  }
}
