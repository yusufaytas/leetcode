/**
 * Copyright © 2021 Yusuf Aytas. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yusufaytas.leetcode;

import java.util.Arrays;

/*
Given an array nums which consists of non-negative integers and an integer m,
you can split the array into m non-empty continuous subarrays.

Write an algorithm to minimize the largest sum among these m subarrays.



Example 1:

Input: nums = [7,2,5,10,8], m = 2
Output: 18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.

Example 2:

Input: nums = [1,2,3,4,5], m = 2
Output: 9

Example 3:

Input: nums = [1,4,4], m = 3
Output: 4

 */
public class SplitArrayLargestSum {

  public int splitArray(final int[] nums, final int m) {
    if (nums == null || nums.length < m) {
      return -1;
    }
    final int[][] splits = new int[nums.length][m];
    for (int i = 0; i < splits.length; i++) {
      Arrays.fill(splits[i], -1);
    }
    return splitArray(nums, splits, 0, m - 1);
  }

  public int splitArray(final int[] nums, final int[][] splits, final int index, final int m) {
    if (splits[index][m] != -1) {
      return splits[index][m];
    }
    if (m == 0) {
      int sum = 0;
      for (int i = index; i < nums.length; i++) {
        sum += nums[i];
      }
      splits[index][m] = sum;
      return sum;
    }
    int min = Integer.MAX_VALUE, sum = 0;
    for (int i = index; i < nums.length - m; i++) {
      sum += nums[i];
      min = Math.min(min, Math.max(splitArray(nums, splits, i + 1, m - 1), sum));
    }
    splits[index][m] = min;
    return min;
  }

  public static void main(String[] args) {
    final int[] nums = {1,4,4};
    final int m = 3;
    System.out.println(new SplitArrayLargestSum().splitArray(nums, m));
  }
}
