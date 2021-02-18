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
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.

Example 2:

Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.

Note:

    You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
    Try to solve it in linear time/space.


 */
public class MaximumGap {

  public int maximumGap(final int[] nums) {
    if (nums == null || nums.length < 2) {
      return 0;
    }
    Arrays.sort(nums);
    int maxGap = 0;
    for (int i = 1; i < nums.length; i++) {
      maxGap = Math.max(nums[i] - nums[i - 1], maxGap);
    }
    return maxGap;
  }

  public static void main(String[] args) {
    final int[] nums = {3, 6, 9, 1};
    System.out.println(new MaximumGap().maximumGap(nums));
  }
}
