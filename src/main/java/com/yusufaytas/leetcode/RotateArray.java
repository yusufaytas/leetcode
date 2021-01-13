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

import static com.yusufaytas.leetcode.Utils.printArray;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:
    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    Could you do it in-place with O(1) extra space?

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

 */
public class RotateArray {

  public static void main(String[] args) {
    final int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
    new RotateArray().rotate(nums, 3);
    printArray(nums);
  }

  public void rotate(final int[] nums, final int k) {
    if (nums == null || nums.length == 0) {
      return;
    }
    for (int i = 0; i < nums.length - (k % nums.length); i++) {
      final int temp = nums[0];
      for (int j = 0; j < nums.length - 1; j++) {
        nums[j] = nums[j + 1];
      }
      nums[nums.length - 1] = temp;
    }
  }
}
