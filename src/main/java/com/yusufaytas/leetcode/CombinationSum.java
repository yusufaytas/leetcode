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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]


 */
public class CombinationSum {

  public static void main(String[] args) {
    final int target = 8;
    final int[] candidates = {2, 3, 5};
    System.out.println(new CombinationSum().combinationSum(candidates, target));
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    final Set<List<Integer>> visited = new HashSet<>();
    final Set<List<Integer>> found = new HashSet<>();
    combinationSum(candidates, target, new ArrayList<>(), visited, found);
    return found.stream().collect(Collectors.toList());
  }

  public void combinationSum(final int[] candidates, final int target, final List<Integer> path,
      final Set<List<Integer>> visited, final Set<List<Integer>> found) {
    if (target == 0) {
      found.add(path);
    }
    if (target < 0 || visited.contains(candidates)) {
      return;
    }
    for (int i = 0; i < candidates.length; i++) {
      final List<Integer> newPath = new ArrayList<>(path);
      newPath.add(candidates[i]);
      Collections.sort(newPath);
      visited.add(newPath);
      combinationSum(candidates, target - candidates[i], newPath, visited, found);
    }
  }

}
