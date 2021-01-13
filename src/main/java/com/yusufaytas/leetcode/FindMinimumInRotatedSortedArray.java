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
Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
For example, the array nums = [0,1,2,4,5,6,7] might become:

    [4,5,6,7,0,1,2] if it was rotated 4 times.
    [0,1,2,4,5,6,7] if it was rotated 7 times.

Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums, return the minimum element of this array.



Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.

 */
public class FindMinimumInRotatedSortedArray {

  public int findMin(final int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    if (nums[0] < nums[nums.length - 1]) {
      return nums[0];
    }
    int start = 0, end = nums.length - 1;
    while (start < end) {
      final int mid = (end - start + 1) / 2 + start;
      if (nums[start] <= nums[end]) {
        end = start;
      } else {
        if (nums[mid] > nums[start]) {
          if (nums[end] < nums[mid]) {
            start = mid + 1;
          } else {
            end = mid;
          }
        } else {
          if (nums[end] > nums[mid]) {
            end = mid;
          } else {
            start = mid + 1;
          }
        }
      }
    }
    return nums[end];
  }

  public static void main(String[] args) {
    final int[] nums = {2, 0, 1};
    System.out.println(new FindMinimumInRotatedSortedArray().findMin(nums));
  }

}
