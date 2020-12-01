package com.yusufaytas.leetcode;

/*
Given an integer array nums, find the contiguous subarray within an array
(containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]

Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

 */
public class MaximumProductSubarray {

  public int maxProduct(final int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      int prev = nums[i];
      max = Math.max(prev, max);
      for (int j = i + 1; j < nums.length; j++) {
        prev *= nums[j];
        max = Math.max(prev, max);
      }
    }
    return max;
  }

}
