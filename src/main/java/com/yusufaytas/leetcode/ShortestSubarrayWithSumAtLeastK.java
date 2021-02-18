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

import java.util.ArrayDeque;
import java.util.Deque;

/*
Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.
If there is no non-empty subarray with sum at least K, return -1.

Example 1:
Input: A = [1], K = 1
Output: 1

Example 2:
Input: A = [1,2], K = 4
Output: -1

Example 3:
Input: A = [2,-1,2], K = 3
Output: 3

Example 4:
Input: A = [1,1,1,1,2,-2,3], K = 7
            1,2,3,4,6,4,7
Output: 2
TODO: REVISIT
 */
public class ShortestSubarrayWithSumAtLeastK {

  public int shortestSubarray(final int[] A, final int K) {
    int min = Integer.MAX_VALUE;
    final int[] sums = new int[A.length + 1];
    for (int i = 1; i <= A.length; i++) {
      sums[i] = A[i - 1] + sums[i - 1];
    }
    final Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i <= A.length; i++) {
      //we can pop from deque when there is a match since there are no other windows that can be smaller
      //than the current one
      while (!deque.isEmpty() && sums[i] - sums[deque.peekFirst()] >= K) {
        min = Math.min(min, i - deque.pollFirst());
      }
      //no need to save one has bigger sum but smaller index
      while (!deque.isEmpty() && sums[i] <= sums[deque.peekLast()]) {
        deque.pollLast();
      }
      deque.addLast(i);
    }
    return min == Integer.MAX_VALUE ? -1 : min;
  }

  public static void main(String[] args) {
    final int[] A = {2, -1, 2, 1};
    final int K = 3;
    System.out.println(new ShortestSubarrayWithSumAtLeastK().shortestSubarray(A, K));
  }
}
