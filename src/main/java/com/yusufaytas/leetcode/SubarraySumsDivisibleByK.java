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
Given an array A of integers, return the number of (contiguous, non-empty)
subarrays that have a sum divisible by K.

Example 1:

Input: A = [4,5,0,-2,-3,1], K = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by K = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

 */
public class SubarraySumsDivisibleByK {

  public int subarraysDivByK(final int[] A, final int K) {
    final int[] sums = new int[K + 1];
    int count = 0;
    int sum = 0;
    sums[0] = 1;
    for (int i = 0; i < A.length; i++) {
      sum = ((A[i] + sum) % K + K) % K;
      count += sums[sum];
      sums[sum]++;
    }
    return count;
  }

  public static void main(String[] args) {
    final int[] A = {4, 5, 0, -2, -3, 1};
    final int K = 5;
    System.out.println(new SubarraySumsDivisibleByK().subarraysDivByK(A, K));
  }
}
