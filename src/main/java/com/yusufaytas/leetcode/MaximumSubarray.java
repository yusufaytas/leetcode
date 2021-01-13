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
Given an integer array nums, find the contiguous subarray
(containing at least one number) which has the largest sum and return its sum.

Follow up: If you have figured out the O(n) solution,
try coding another solution using the divide and conquer approach, which is more subtle.

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {

  public static void main(String[] args) {
    final int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(new MaximumSubarray().maxSubArray(nums));
  }

  public int maxSubArray(final int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int max = nums[0], localMax = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] + localMax < nums[i]) {
        localMax = nums[i];
      } else if (nums[i] + localMax < 0) {
        localMax = nums[i];
      } else {
        localMax = nums[i] + localMax;
      }
      if (localMax > max) {
        max = localMax;
      }
    }
    return max;
  }
}

