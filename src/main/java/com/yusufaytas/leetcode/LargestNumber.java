package com.yusufaytas.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
Given a list of non-negative integers nums, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.

Example 1:

Input: nums = [10,2]
Output: "210"

Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"

Example 3:

Input: nums = [1]
Output: "1"

Example 4:

Input: nums = [10]
Output: "10"

 */
public class LargestNumber {

  public static void main(String[] args) {
    final int[] nums = new int[]{0, 0};
    System.out.println(new LargestNumber().largestNumber(nums));
  }

  public String largestNumber(final int[] nums) {
    if (nums == null || nums.length == 0) {
      return "";
    }
    final String number = Arrays.stream(nums).mapToObj(i -> Integer.toString(i))
        .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
        .collect(Collectors.joining(""));
    if (number.startsWith("0")) {
      return "0";
    }
    return number;
  }
}
