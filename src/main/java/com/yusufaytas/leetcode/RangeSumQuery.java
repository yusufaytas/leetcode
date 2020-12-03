package com.yusufaytas.leetcode;

/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Implement the NumArray class:

    NumArray(int[] nums) Initializes the object with the integer array nums.
    int sumRange(int i, int j) Return the sum of the elements of the nums
    array in the range [i, j] inclusive (i.e., sum(nums[i], nums[i + 1], ... , nums[j]))

Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))

 */
public class RangeSumQuery {

  static class NumArray {

    final int[] sums;

    public NumArray(final int[] nums) {
      if (nums == null) {
        throw new IllegalArgumentException();
      }
      sums = new int[nums.length];
      if (nums.length > 0) {
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
          sums[i] = nums[i] + sums[i - 1];
        }
      }
    }

    public int sumRange(final int i, final int j) {
      if (i >= sums.length || j >= sums.length || i > j || i < 0 || j < 0) {
        return -1;
      }
      return sums[j] - (i > 0 ? sums[i - 1] : 0);
    }
  }

  public static void main(String[] args) {
    final int[] nums = {-4,-5};
    System.out.println(new NumArray(nums).sumRange(1, 1));
  }

}
