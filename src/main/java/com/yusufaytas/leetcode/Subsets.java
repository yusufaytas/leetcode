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

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class Subsets {

  public static void main(String[] args) {
    final int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10, 0};
    System.out.println(new Subsets().subsets(nums));
  }

  public List<List<Integer>> subsets(final int[] nums) {
    final Set<Set<Integer>> allSubsets = new HashSet<>();
    final List<Integer> numList = IntStream.of(nums).boxed()
        .collect(Collectors.toCollection(LinkedList::new));
    subsets(allSubsets, numList);
    return allSubsets.stream().map(set -> set.stream().collect(Collectors.toList()))
        .collect(Collectors.toList());
  }

  public void subsets(final Set<Set<Integer>> allSubsets, final List<Integer> numList) {
    if (!allSubsets.add(new HashSet<>(numList))) {
      return;
    }
    for (int i = 0; i < numList.size(); i++) {
      final int removal = numList.remove(0);
      subsets(allSubsets, numList);
      numList.add(removal);
    }
  }
}
