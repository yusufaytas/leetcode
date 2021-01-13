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
import java.util.Set;
import java.util.Stack;

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LongestConsecutiveSequence {

  public static void main(final String[] args) {
    int nums[] = {100, 4, 200, 1, 3, 2, 0, 5};

    System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));
  }

  public int longestConsecutive(final int[] nums) {
    final Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
    }
    int max = 0;
    final Stack<Integer> stack = new Stack();
    while (!set.isEmpty()) {
      int currentMax = 0;
      stack.push(set.iterator().next());
      set.remove(stack.peek());
      while (!stack.isEmpty()) {
        int current = stack.pop();
        currentMax++;
        max = Math.max(currentMax, max);
        addIfExists(set, stack, current + 1);
        addIfExists(set, stack, current - 1);
      }
    }
    return max;
  }

  private void addIfExists(final Set<Integer> set, final Stack<Integer> stack, final int current) {
    if (set.contains(current)) {
      set.remove(current);
      stack.push(current);
    }
  }
}
