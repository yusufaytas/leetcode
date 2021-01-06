package com.yusufaytas.leetcode;

/*
Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p. It is not allowed to remove the whole array.

Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.

A subarray is defined as a contiguous block of elements in the array.



Example 1:

Input: nums = [3,1,4,2], p = 6
Output: 1
Explanation: The sum of the elements in nums is 10, which is not divisible by 6.
We can remove the subarray [4], and the sum of the remaining elements is 6, which is divisible by 6.

Example 2:

Input: nums = [6,3,5,2], p = 9
Output: 2
Explanation: We cannot remove a single element to get a sum divisible by 9.
The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.

Example 3:

Input: nums = [1,2,3], p = 3
Output: 0
Explanation: Here the sum is 6. which is already divisible by 3. Thus we do not need to remove anything.

Example 4:

Input: nums = [1,2,3], p = 7
Output: -1
Explanation: There is no way to remove a subarray in order to get a sum divisible by 7.

Example 5:

Input: nums = [1000000000,1000000000,1000000000], p = 3
Output: 0
s
 */
public class MakeSumDivisibleByP {

  public int minSubarray(final int[] nums, final int p) {
    int total = 0;
    for (int i = 0; i < nums.length; i++) {
      total = (nums[i] + total) % p;
    }
    if (total == 0) {
      return 0;
    }
    int min = nums.length;
    for (int i = 0; i < nums.length; i++) {
      int currentTotal = 0;
      for (int j = i; j < nums.length; j++) {
        currentTotal += nums[j];
        if (currentTotal % p == total) {
          min = Math.min(j - i + 1, min);
        }
      }
    }
    return min < nums.length ? min : -1;
  }

  public static void main(String[] args) {
    final int[] nums = {26, 19, 11, 14, 18, 4, 7, 1, 30, 23, 19, 8, 10, 6, 26, 3};
    final int p = 26;
    System.out.println(new MakeSumDivisibleByP().minSubarray(nums, p));
  }
}
