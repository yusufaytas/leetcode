/**
 * Copyright © 2021 Yusuf Aytas. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.yusufaytas.leetcode;

import java.util.TreeMap;

/*
Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:

Input: nums = [-2,5,-1,-2], lower = -2, upper = 2,
Output: 3
Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.

sum - upper <= remaining
sum - lower >= remaining
 */
public class CountOfRangeSum {

  public int countRangeSum(final int[] nums, final int lower, final int upper) {
    final TreeMap<Long, Integer> sums = new TreeMap<>();
    long sum = 0;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum >= lower && sum <= upper) {
        count++;
      }
      Long floorKey = sums.floorKey(sum - lower);
      while (floorKey != null && sum - floorKey <= upper) {
        count += sums.get(floorKey);
        floorKey = sums.floorKey(floorKey - 1);
      }
      sums.put(sum, sums.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

  public static void main(String[] args) {
    final int[] nums = {-2147483647, 0, -2147483647, 2147483647};
    final int lower = -564, upper = 3864;
    System.out.println(new CountOfRangeSum().countRangeSum(nums, lower, upper));
  }

}
