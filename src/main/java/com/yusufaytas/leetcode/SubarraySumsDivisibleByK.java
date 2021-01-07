package com.yusufaytas.leetcode;

/*
Given an array A of integers, return the number of (contiguous, non-empty)
subarrays that have a sum divisible by K.

Example 1:

Input: A = [4,5,0,-2,-3,1], K = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by K = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

 */
public class SubarraySumsDivisibleByK {

  public int subarraysDivByK(final int[] A, final int K) {
    final int[] sums = new int[K + 1];
    int count = 0;
    int sum = 0;
    sums[0] = 1;
    for (int i = 0; i < A.length; i++) {
      sum = ((A[i] + sum) % K + K) % K;
      count += sums[sum];
      sums[sum]++;
    }
    return count;
  }

  public static void main(String[] args) {
    final int[] A = {4, 5, 0, -2, -3, 1};
    final int K = 5;
    System.out.println(new SubarraySumsDivisibleByK().subarraysDivByK(A, K));
  }
}
