package com.yusufaytas.leetcode;

import java.util.Arrays;

/*
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it
represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[left] * nums[i] * nums[right] coins. Here left
and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Return the maximum coins you can collect by bursting the balloons wisely.

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167

Example 2:
Input: nums = [1,5]
Output: 10

//TODO: revisit
 */
public class BurstBalloons {

  public int maxCoins(final int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    final int[][] visited = new int[nums.length][nums.length];
    for (int i = 0; i < nums.length; i++) {
      Arrays.fill(visited[i], -1);
    }
    return maxCoins(nums, visited, 0, nums.length - 1);
  }

  public int maxCoins(final int[] nums, final int[][] visited, final int start, final int end) {
    if (start > end) {
      return 0;
    }
    if (visited[start][end] != -1) {
      return visited[start][end];
    }
    int max = 0;
    for (int i = start; i <= end; i++) {
      final int leftMax = maxCoins(nums, visited, start, i - 1);
      final int rightMax = maxCoins(nums, visited, i + 1, end);
      final int product = (start > 0 ? nums[start - 1] : 1) *
          (end < nums.length - 1 ? nums[end + 1] : 1) * nums[i];
      max = Math.max(max, product + leftMax + rightMax);
    }
    return visited[start][end] = max;
  }

  public static void main(String[] args) {
    final int[] nums = {3, 1, 5, 8};
    System.out.println(new BurstBalloons().maxCoins(nums));
  }
}
