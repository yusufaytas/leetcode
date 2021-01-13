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

import java.util.Arrays;

/*
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].

Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
TODO: revisit
 */
public class WiggleSort2 {

  public static void main(final String[] args) {
    final int[] nums = {2, 3, 1, 3, 1, 2};
    new WiggleSort2().wiggleSort(nums);
    printArray(nums);
  }

  public void wiggleSort(final int[] nums) {
    if (nums == null || nums.length < 2) {
      return;
    }
    final int[] copy = Arrays.copyOf(nums, nums.length);

    Arrays.sort(copy);

    int smallHalfEnd = (nums.length - 1) / 2;
    int bigHalfEnd = nums.length - 1;

    for (int i = 0; i < nums.length; i++) {
      if (i % 2 == 0) {
        nums[i] = copy[smallHalfEnd--];
      } else {
        nums[i] = copy[bigHalfEnd--];
      }
    }
  }
}
