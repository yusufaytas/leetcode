package com.yusufaytas.leetcode;

/*
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

Example 1:

Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.

Example 2:

Input: nums = [4,2,1]
Output: false
Explanation: You can't get a non-decreasing array by modify at most one element.

 */
public class NonDecreasingArray {

  public boolean checkPossibility(final int[] nums) {
    if (nums == null || nums.length < 3) {
      return true;
    }
    int modificationsNeeded = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > nums[i]) {
        if (i + 1 < nums.length) {
          if (nums[i - 1] > nums[i + 1]) {
            nums[i - 1] = nums[i];
          } else {
            nums[i] = nums[i - 1];
          }
        } else {
          nums[i] = nums[i-1];
        }
        modificationsNeeded++;
      }
    }
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > nums[i]) {
        return false;
      }
    }
    return modificationsNeeded <= 1;
  }

  public static void main(String[] args) {
    final int[] nums = {1, 3, 2};
    System.out.println(new NonDecreasingArray().checkPossibility(nums));
  }
}
