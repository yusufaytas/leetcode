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
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:

Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

Note:

    Then length of the input array is in range [1, 10,000].
    The input array may contain duplicates, so ascending order here means <=.

 */
public class ShortestUnsortedContinuousSubarray {

  public static void main(String[] args) {
    int nums[] = {2, 6, 4, 8, 10, 9, 15};
    System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(nums));
  }

  public int findUnsortedSubarray(final int[] nums) {
    final int sortedSums[] = Arrays.copyOf(nums, nums.length);
    Arrays.sort(nums);
    int startIndex = -1, endIndex = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == sortedSums[i]) {
        continue;
      }
      if (startIndex == -1) {
        startIndex = i;
      }
      endIndex = i;
    }
    if (startIndex == -1) {
      return 0;
    }
    return endIndex - startIndex + 1;
  }
}
