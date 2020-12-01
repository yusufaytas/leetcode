package com.yusufaytas.leetcode;

/*
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3

Example 2:

Input: [3,4,-1,1]
Output: 2

Example 3:

Input: [7,8,9,11,12]
Output: 1

Note:
Your algorithm should run in O(n) time and uses constant extra space.

 */
public class FirstMissingPositive {

  public static void main(String[] args) {
    final int[] nums = {2, 1};
    System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
  }

  // The question is tricky since you don't assume you could modify the array values. The solution requires modifying
  // array values.
  public int firstMissingPositive(final int[] nums) {
    if (nums.length == 0) {
      return 1;
    }
    int nonPositiveCount = 0, max = nums[0];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 1) {
        nonPositiveCount++;
      }
      if (nums[i] > max) {
        max = nums[i];
      }
    }
    for (int i = 0, j = nums.length - 1; i < nums.length; i++) {
      if (nums[i] < 1) {
        while (nums[j] < 1 && j > i) {
          j--;
        }
        if (j == i) {
          break;
        }
        swap(nums, i, j);
      }
    }
    final int end = nums.length - nonPositiveCount;
    for (int i = 0; i < end; i++) {
      final int index = Math.abs(nums[i]) - 1;
      if (index < end) {
        nums[index] = -Math.abs(nums[index]);
      }
    }
    if (nums[0] > 0) {
      return 1;
    }
    for (int i = 1; i < end; i++) {
      if (nums[i] > 0) {
        return i + 1;
      }
    }
    return end - 1 >= 0 ? max + 1 : 1;
  }

  public void swap(final int[] nums, final int i, final int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
