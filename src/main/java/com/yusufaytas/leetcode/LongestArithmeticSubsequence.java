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
Given an array A of integers, return the length of the longest arithmetic subsequence in A.

Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k]
with 0 <= i_1 < i_2 < ... < i_k <= A.length - 1, and that a sequence B is arithmetic if B[i+1] - B[i]
are all the same value (for 0 <= i < B.length - 1).

Example 1:

Input: A = [3,6,9,12]
Output: 4
Explanation:
The whole array is an arithmetic sequence with steps of length = 3.

Example 2:

Input: A = [9,4,7,2,10]
Output: 3
Explanation:
The longest arithmetic subsequence is [4,7,10].

Example 3:

Input: A = [20,1,15,3,10,5,8]
Output: 4
Explanation:
The longest arithmetic subsequence is [20,15,10,5].

 */
public class LongestArithmeticSubsequence {

  public int longestArithSeqLength(final int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length <= 2) {
      return nums.length;
    }
    int max = 1;
    final Map<Integer, Integer>[] subsequences = new Map[nums.length];
    for (int i = 0; i < subsequences.length; i++) {
      subsequences[i] = new HashMap<>();
    }
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        final int count = subsequences[j].getOrDefault(nums[i] - nums[j], 1) + 1;
        subsequences[i].put(nums[i] - nums[j], count);
        if (count > max) {
          max = count;
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    final int[] nums = {0, 8, 45, 88, 48, 68, 28, 55, 17, 24};
    System.out.println(new LongestArithmeticSubsequence().longestArithSeqLength(nums));
  }

}
