package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

 */
public class FindAllNumbersDisappearedInArray {

  public List<Integer> findDisappearedNumbers(final int[] nums) {
    final List<Integer> disappearedNumbers = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        disappearedNumbers.add(i + 1);
      }
    }
    return disappearedNumbers;
  }
}
