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
We partition a row of numbers A into at most K adjacent (non-empty) groups,
then our score is the sum of the average of each group. What is the largest score we can achieve?

Note that our partition must use every number in A, and that scores are not necessarily integers.

Example:
Input:
A = [9,1,2,3,9]
K = 3
Output: 20
Explanation:
The best choice is to partition A into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
We could have also partitioned A into [9, 1], [2], [3, 9], for example.
That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
 */
public class LargestSumOfAverages {

  public double largestSumOfAverages(final int[] A, final int K) {
    if (A == null || A.length == 0 || K > A.length) {
      return -1;
    }
    final double[][] maxAverages = new double[A.length][K];
    return largest(A, 0, K - 1, maxAverages);
  }

  public double largest(final int[] A, final int index, final int K,
      final double[][] maxAverages) {
    if (maxAverages[index][K] != 0) {
      return maxAverages[index][K];
    }
    if (K == 0) {
      double sum = 0;
      for (int i = index; i < A.length; i++) {
        sum += A[i];
      }
      maxAverages[index][K] = sum / (A.length - index);
      return maxAverages[index][K];
    }
    double max = -1, currentSum = 0;
    for (int i = index; i < A.length - K; i++) {
      currentSum += A[i];
      max = Math.max(max, largest(A, i + 1, K - 1, maxAverages) + currentSum / (i - index + 1));
    }
    maxAverages[index][K] = max;
    return max;
  }

  public static void main(final String[] args) {
    final int A[] = {1, 2, 3, 4, 5, 6, 7};
    final int K = 4;
    System.out.println(new LargestSumOfAverages().largestSumOfAverages(A, K));
  }
}
