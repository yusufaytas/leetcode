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
Given an integer array nums, find the contiguous subarray within an array
(containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]

Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

 */
public class MaximumProductSubarray {

  public int maxProduct(final int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      int prev = nums[i];
      max = Math.max(prev, max);
      for (int j = i + 1; j < nums.length; j++) {
        prev *= nums[j];
        max = Math.max(prev, max);
      }
    }
    return max;
  }

}
