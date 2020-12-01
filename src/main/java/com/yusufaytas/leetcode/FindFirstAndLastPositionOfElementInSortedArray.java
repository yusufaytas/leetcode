package com.yusufaytas.leetcode;

import java.util.Arrays;

/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

 */
public class FindFirstAndLastPositionOfElementInSortedArray {

  public static void main(String[] args) {
    final int target = 10;
    final int nums[] = {5, 7, 7, 7, 8, 8, 10};
    System.out.println(Arrays
        .toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums, target)));
  }

  public int[] searchRange(final int[] nums, final int target) {
    final int index = Arrays.binarySearch(nums, target);
    if (index < 0) {
      return new int[]{-1, -1};
    }
    final int lowerIndex = search(nums, 0, nums.length - 1, target - 0.5);
    final int higherIndex = search(nums, 0, nums.length - 1, target + 0.5);
    return new int[]{lowerIndex >= 0 && nums[lowerIndex] == target ? lowerIndex : lowerIndex + 1,
        higherIndex < nums.length && nums[higherIndex] == target ? higherIndex : higherIndex - 1};
  }

  public int search(final int[] nums, final int start, final int end, final double target) {
    final int mid = (start + end) / 2;
    if (start >= end) {
      if (nums[start] > target) {
        return start - 1;
      }
      return start + 1;
    }
    if (nums[mid] > target) {
      return search(nums, start, mid - 1, target);
    }
    return search(nums, mid + 1, end, target);
  }
}
