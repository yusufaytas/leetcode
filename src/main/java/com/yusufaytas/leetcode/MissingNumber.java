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
Given an array nums containing n distinct numbers in the range [0, n],
return the only number in the range that is missing from the array.

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 */
public class MissingNumber {

  public static void main(String[] args) {
    final int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
    System.out.println(new MissingNumber().missingNumber(nums));
  }

  public int missingNumber(final int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] = nums[i] + 1;
    }
    for (int i = 0; i < nums.length; i++) {
      if (Math.abs(nums[i]) - 1 < nums.length) {
        nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
      }
    }
    printArray(nums);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        return i;
      }
    }
    return nums.length;
  }

}
