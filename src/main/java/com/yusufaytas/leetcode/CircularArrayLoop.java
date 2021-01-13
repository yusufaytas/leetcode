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
You are given a circular array nums of positive and negative integers.
 If a number k at an index is positive, then move forward k steps. Conversely, if it's negative (-k),
 move backward k steps. Since the array is circular, you may assume that the last element's next
 element is the first element, and the first element's previous element is the last element.

Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index
and the cycle's length > 1. Furthermore, movements in a cycle must all follow a single direction.
In other words, a cycle must not consist of both forward and backward movements

Example 1:

Input: [2,-1,1,2,2]
Output: true
Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.

Example 2:

Input: [-1,2]
Output: false
Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length is 1.
By definition the cycle's length must be greater than 1.

Example 3:

Input: [-2,1,-1,-2,-2]
Output: false
Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, because movement
from index 1 -> 2 is a forward movement, but movement from index 2 -> 1 is a backward movement.
All movements in a cycle must follow a single direction.
 */
public class CircularArrayLoop {

  public static void main(String[] args) {
    final int[] nums = {-1, -1, -1};
    System.out.println(new CircularArrayLoop().circularArrayLoop(nums));
  }

  public boolean circularArrayLoop(final int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int nextIndex = i;
      int cycleLength = 0;
      boolean isForward = nums[nextIndex] > 0;
      final boolean[] visited = new boolean[nums.length];
      do {
        if (nums[i] >= nums.length || visited[(nextIndex % nums.length + nums.length)
            % nums.length]) {
          break;
        }
        visited[(nextIndex % nums.length + nums.length) % nums.length] = true;
        final int newNextIndex =
            nums[(nextIndex % nums.length + nums.length) % nums.length] + nextIndex;
        if ((isForward && newNextIndex < nextIndex) || (!isForward && newNextIndex > nextIndex)) {
          break;
        }
        cycleLength++;
        nextIndex = newNextIndex;
        if ((nextIndex % nums.length + nums.length) % nums.length == i && cycleLength > 1) {
          return true;
        }
      } while (!visited[(nextIndex % nums.length + nums.length) % nums.length]);
    }
    return false;
  }
}
