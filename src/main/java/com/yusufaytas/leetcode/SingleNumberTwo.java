package com.yusufaytas.leetcode;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Given an integer array nums where every element appears three times except for one,
which appears exactly once. Find the single element and return it.

Example 1:

Input: nums = [2,2,3,2]
Output: 3

Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99

Constraints:

    1 <= nums.length <= 3 * 104
    -231 <= nums[i] <= 231 - 1
    Each element in nums appears exactly three times except for one element which appears once.

Follow up: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 */
public class SingleNumberTwo {

  public int singleNumber(final int[] nums) {
    return IntStream.of(nums).boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream().filter(e -> e.getValue() == 1).findFirst().get().getKey();
  }
}
