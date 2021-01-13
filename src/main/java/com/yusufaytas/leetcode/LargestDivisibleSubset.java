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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Given a set of distinct positive integers, find the largest subset such that every pair
(Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)

Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]

//TODO: revisit
 */
public class LargestDivisibleSubset {

  public List<Integer> largestDivisibleSubset(int[] nums) {
    if (nums == null || nums.length == 0) {
      return Collections.emptyList();
    }
    Arrays.sort(nums);
    final List<Integer>[] divisibleSubsets = new List[nums.length];
    for (int i = 0; i < nums.length; i++) {
      divisibleSubsets[i] = new ArrayList<>(Arrays.asList(nums[i]));
    }
    List<Integer> max = divisibleSubsets[0];
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] % nums[j] == 0 && divisibleSubsets[j].size() >= divisibleSubsets[i].size()) {
          divisibleSubsets[i] = new ArrayList<>(divisibleSubsets[j]);
          divisibleSubsets[i].add(nums[i]);
          if (divisibleSubsets[i].size() > max.size()) {
            max = divisibleSubsets[i];
          }
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 9, 27, 81};
    System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(nums));
  }
}
