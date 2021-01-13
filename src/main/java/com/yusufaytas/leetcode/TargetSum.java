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

/*
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5
Explanation:

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.

Constraints:

    The length of the given array is positive and will not exceed 20.
    The sum of elements in the given array will not exceed 1000.
    Your output answer is guaranteed to be fitted in a 32-bit integer.


 */
public class TargetSum {

  public static void main(String[] args) {
    final int[] nums = new int[]{1, 1, 1, 1, 1};
    System.out.println(new TargetSum().findTargetSumWays(nums, 3));
  }

  public int findTargetSumWays(int[] nums, int S) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    return findTargetSumWays(nums, 0, S);
  }

  public int findTargetSumWays(final int[] nums, final int index, final int target) {
    if (index == nums.length) {
      if (target == 0) {
        return 1;
      }
      return 0;
    }
    return findTargetSumWays(nums, index + 1, target - nums[index])
        + findTargetSumWays(nums, index + 1, target + nums[index]);
  }

}
