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
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Permutations {

  public static void main(String[] args) {
    final int[] nums = new int[]{1, 2, 3};
    System.out.println(new Permutations().permute(nums));
  }

  public List<List<Integer>> permute(int[] nums) {
    final List<List<Integer>> permutations = new ArrayList<>();
    final Queue<Integer> remaining = Arrays.stream(nums)
        .boxed()
        .collect(Collectors.toCollection(LinkedList::new));
    final List<Integer> permutation = new LinkedList<>();
    permute(permutations, permutation, remaining);
    return permutations;
  }

  public void permute(final List<List<Integer>> permutations, final List<Integer> permutation,
      final Queue<Integer> remaining) {
    if (remaining.isEmpty()) {
      permutations.add(new ArrayList<>(permutation));
    }
    for (int i = 0; i < remaining.size(); i++) {
      final int removed = remaining.poll();
      permutation.add(removed);
      permute(permutations, permutation, remaining);
      permutation.remove(permutation.size() - 1);
      remaining.add(removed);
    }
  }
}
