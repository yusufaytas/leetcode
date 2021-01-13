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
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3

Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 */
public class MajorityElement {

  public int majorityElement(final int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    Arrays.sort(nums);
    int current = nums[0], currentMaxCount = 1, maxCount = 1, max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == current) {
        maxCount++;
        if (maxCount > currentMaxCount) {
          currentMaxCount = maxCount;
          max = current;
        }
      } else {
        maxCount = 1;
        current = nums[i];
      }
    }
    return max;
  }

}
