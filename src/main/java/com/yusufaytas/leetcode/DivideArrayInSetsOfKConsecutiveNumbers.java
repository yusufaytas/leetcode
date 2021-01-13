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

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Given an array of integers nums and a positive integer k, find whether it's possible to divide
this array into sets of k consecutive numbers
Return True if its possible otherwise return False.

Example 1:

Input: nums = [1,2,3,3,4,4,5,6], k = 4
Output: true
Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].

Example 2:

Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
Output: true
Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].

Example 3:

Input: nums = [3,3,2,2,1,1], k = 3
Output: true

Example 4:

Input: nums = [1,2,3,4], k = 3
Output: false
Explanation: Each array should be divided in subarrays of size 3.

 */
public class DivideArrayInSetsOfKConsecutiveNumbers {

  public static void main(String[] args) {
    final int[] nums = {1, 1, 2, 2, 3, 3};
    final int k = 3;
    System.out.println(new DivideArrayInSetsOfKConsecutiveNumbers().isPossibleDivide(nums, k));
  }

  public boolean isPossibleDivide(final int[] nums, final int k) {
    if (nums == null || nums.length == 0 || nums.length % k != 0) {
      return false;
    }
    final Map<Integer, Integer> counts = IntStream.of(nums).boxed()
        .collect(Collectors.groupingBy(Function.identity(),
            Collectors.reducing(0, e -> 1, Integer::sum)));
    for (int i = 0; i < nums.length / k; i++) {
      final int min = counts.keySet().stream().min(Integer::compareTo).get();
      final int minCount = counts.get(min).intValue();
      if (minCount == 1) {
        counts.remove(min);
      } else {
        counts.put(min, minCount - 1);
      }
      for (int j = min + 1; j < k + min; j++) {
        if (!counts.containsKey(j)) {
          return false;
        }
        final int currentCount = counts.get(j).intValue();
        if (currentCount == 1) {
          counts.remove(j);
        } else {
          counts.put(j, currentCount - 1);
        }
      }
    }
    return true;
  }
}
