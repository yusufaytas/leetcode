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
Given a list of non-negative numbers and a target integer k, write a function to check if the array has a
continuous subarray of size at least 2 that sums up to the multiple of k,
that is, sums up to n*k where n is also an integer.

Example 1:
Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:
Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
Note:
The length of the array won't exceed 10,000.
You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */
public class ContinuousSubarraySum {

  public static void main(String[] args) {
    int k = 0;
    int nums[] = {0, 1, 0};
    System.out.println(new ContinuousSubarraySum().checkSubarraySum(nums, k));
  }

  public boolean checkSubarraySum(int[] nums, int k) {
    for (int i = 0; i < nums.length; i++) {
      int sum = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        sum += nums[j];
        if (((k == 0 && sum == 0) || (k != 0 && sum % k == 0))) {
          return true;
        }
      }
    }
    return false;
  }
}
