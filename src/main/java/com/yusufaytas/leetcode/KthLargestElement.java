package com.yusufaytas.leetcode;

import java.util.Arrays;


/*
Find the kth largest element in an unsorted array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4

Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.

 */
public class KthLargestElement {

  public static void main(String[] args) {
    final int[] nums = {3, 2, 1, 5, 6, 4};
    System.out.println(new KthLargestElement().findKthLargest(nums, 2));
  }

  public int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    Arrays.sort(nums);
    return nums[nums.length - k];
  }
}
