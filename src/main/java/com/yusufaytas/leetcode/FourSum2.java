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

import java.util.HashMap;
import java.util.Map;

/*
Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l)
there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

 */
public class FourSum2 {

  public static void main(String[] args) {
    final int[] A = {1, 2};
    final int[] B = {-2, -1};
    final int[] C = {-1, 2};
    final int[] D = {0, 2};
    System.out.println(new FourSum2().fourSumCount(A, B, C, D));
  }

  public int fourSumCount(final int[] A, final int[] B, final int[] C, final int[] D) {
    if (A == null || A.length == 0
        || B == null || B.length == 0
        || C == null || C.length == 0
        || D == null || D.length == 0) {
      return 0;
    }
    final Map<Integer, Integer> aPlusB = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < B.length; j++) {
        final int sum = A[i] + B[j];
        aPlusB.put(sum, aPlusB.getOrDefault(sum, 0) + 1);
      }
    }
    final Map<Integer, Integer> cPlusD = new HashMap<>();
    for (int i = 0; i < C.length; i++) {
      for (int j = 0; j < D.length; j++) {
        final int sum = C[i] + D[j];
        cPlusD.put(sum, cPlusD.getOrDefault(sum, 0) + 1);
      }
    }
    int count = 0;
    for (final Map.Entry<Integer, Integer> aAndB : aPlusB.entrySet()) {
      if (cPlusD.containsKey(-aAndB.getKey())) {
        count += cPlusD.get(-aAndB.getKey()) * aAndB.getValue();
      }
    }
    return count;
  }
}
