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

import java.util.HashMap;
import java.util.Map;

/*
Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p. It is not allowed to remove the whole array.

Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.

A subarray is defined as a contiguous block of elements in the array.



Example 1:

Input: nums = [3,1,4,2], p = 6
Output: 1
Explanation: The sum of the elements in nums is 10, which is not divisible by 6.
We can remove the subarray [4], and the sum of the remaining elements is 6, which is divisible by 6.

Example 2:

Input: nums = [6,3,5,2], p = 9
Output: 2
Explanation: We cannot remove a single element to get a sum divisible by 9.
The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.

Example 3:

Input: nums = [1,2,3], p = 3
Output: 0
Explanation: Here the sum is 6. which is already divisible by 3. Thus we do not need to remove anything.

Example 4:

Input: nums = [1,2,3], p = 7
Output: -1
Explanation: There is no way to remove a subarray in order to get a sum divisible by 7.

Example 5:

Input: nums = [1000000000,1000000000,1000000000], p = 3
Output: 0
s
TODO: revisit
 */
public class MakeSumDivisibleByP {

  public int minSubarray(final int[] nums, final int p) {
    int total = 0;
    for (int i = 0; i < nums.length; i++) {
      total = (nums[i] + total) % p;
    }
    if (total == 0) {
      return 0;
    }
    int min = nums.length, sum = 0;
    final Map<Integer, Integer> diffMap = new HashMap<>();
    diffMap.put(0, -1); // this is needed when sum equals to total
    for (int i = 0; i < nums.length; i++) {
      sum = (nums[i] + sum) % p;
      //diff + total = sum, we wan to get rid of total, so indexes between sum and diff
      final int diff = (sum - total + p) % p;
      if (diffMap.containsKey(diff)) {
        min = Math.min(i - diffMap.get(diff), min);
      }
      diffMap.put(sum, i);
    }
    return min < nums.length ? min : -1;
  }

  public static void main(String[] args) {
    final int[] nums = {8, 32, 31, 18, 34, 20, 21, 13, 1, 27, 23, 22, 11, 15, 30, 4, 2};
    final int p = 148;
    System.out.println(new MakeSumDivisibleByP().minSubarray(nums, p));
  }
}
