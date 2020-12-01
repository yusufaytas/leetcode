package com.yusufaytas.leetcode;

/*
Given an array of n positive integers and a positive integer s,
find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {

  public static void main(String[] args) {
    int k = 4;
    int nums[] = {0, 1, 1, 2, 2};
    System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(k, nums));
  }

  public int minSubArrayLen(int s, int[] nums) {
    long sum = 0;
    boolean isFound = false;
    int minLengthSoFar = Integer.MAX_VALUE, start = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= s) {
        return 1;
      }
      sum += nums[i];
      if (sum >= s) {
        long newSum = sum;
        int currentStart = start;
        while (newSum >= s) {
          newSum -= nums[currentStart];
          if (newSum < s) {
            break;
          }
          currentStart++;
        }
        int minLength = i - currentStart + 1;
        if (minLengthSoFar >= minLength) {
          minLengthSoFar = minLength;
          isFound = true;
        }
      }
    }
    if (isFound) {
      return minLengthSoFar;
    }
    return 0;
  }
}
