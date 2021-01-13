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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation:
The repeated subarray with maximum length is [3, 2, 1].
 */
public class MaximumLengthOfRepeatedSubarray {

  public int findLength(final int[] A, final int[] B) {
    if (A == null || B == null || A.length == 0 || B.length == 0) {
      return 0;
    }
    final Map<Integer, List<Integer>> indexes = new HashMap<>();
    for (int i = 0; i < B.length; i++) {
      if (!indexes.containsKey(B[i])) {
        indexes.put(B[i], new ArrayList<>());
      }
      indexes.get(B[i]).add(i);
    }
    int max = 0;
    for (int i = 0; i < A.length; i++) {
      final List<Integer> correspondingIndexes = indexes.get(A[i]);
      if (correspondingIndexes == null) {
        continue;
      }
      for (int j = 0; j < correspondingIndexes.size(); j++) {
        for (int k = correspondingIndexes.get(j), l = i;
            k < B.length && l < A.length && A[l] == B[k]; k++, l++) {
          max = Math.max(l - i + 1, max);
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    final int[] A = {0, 0, 0, 0, 0};
    final int[] B = {0, 0, 0, 0, 0};
    System.out.println(new MaximumLengthOfRepeatedSubarray().findLength(A, B));
  }
}
