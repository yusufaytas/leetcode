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
You are a professional robber planning to rob houses along a street. Each house has a certain
amount of money stashed. All houses at this place are arranged in a circle. That means the
first house is the neighbor of the last one. Meanwhile, adjacent houses have a security
system connected, and it will automatically contact the police if two adjacent houses were
broken into on the same night.

Given a list of non-negative integers nums representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
because they are adjacent houses.

Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 3:

Input: nums = [0]
Output: 0

 */
public class HouseRobberTwo {

  public int rob(final int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    //0 => first not included, not included
    //1 => first not included,included
    //2 => first included, not included
    //3 => first included, included
    final int[][] max = new int[nums.length][4];
    max[0][3] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]);
      max[i][1] = max[i - 1][0] + nums[i];
      max[i][2] = Math.max(max[i - 1][2], max[i - 1][3]);
      max[i][3] = i == nums.length - 1 ? max[i - 1][2] : max[i - 1][2] + nums[i];
    }
    return Math.max(Math.max(max[nums.length - 1][2], max[nums.length - 1][3]),
        Math.max(max[nums.length - 1][0], max[nums.length - 1][1]));
  }

  public static void main(String[] args) {
    final int[] nums = {2, 3, 2};
    System.out.println(new HouseRobberTwo().rob(nums));
  }
}
