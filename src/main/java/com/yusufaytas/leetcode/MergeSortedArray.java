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
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.

Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {

  public static void main(String[] args) {
    final int[] nums1 = {1, 2, 3, 0, 0, 0};
    final int[] nums2 = {2, 5, 6};
    new MergeSortedArray().merge(nums1, 3, nums2, 3);
    printArray(nums1);
  }

  public void merge(final int[] nums1, final int m, final int[] nums2, final int n) {
    for (int i = 1; i <= m; i++) {
      nums1[nums1.length - i] = nums1[m - i];
    }
    int i = nums1.length - m, j = 0, k = 0;
    while (k < n + m) {
      if (i == nums1.length) {
        nums1[k++] = nums2[j++];
      } else if (j == n) {
        nums1[k++] = nums1[i++];
      } else if (nums1[i] > nums2[j]) {
        nums1[k++] = nums2[j++];
      } else {
        nums1[k++] = nums1[i++];
      }
    }
  }
}
