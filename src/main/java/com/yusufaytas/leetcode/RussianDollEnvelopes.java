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

import java.util.Arrays;
import java.util.Comparator;

/*
You have a number of envelopes with widths and heights given as a pair of integers (w, h).
One envelope can fit into another if and only if both the width and height of one envelope is
greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Note:
Rotation is not allowed.

Example:

Input: [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
public class RussianDollEnvelopes {

  public int maxEnvelopes(final int[][] envelopes) {
    if (envelopes == null || envelopes.length == 0) {
      return 0;
    }
    Arrays.sort(envelopes, Comparator.comparingInt(o -> -o[0]));
    final int[] max = new int[envelopes.length];
    Arrays.fill(max, 1);
    int totalMax = 1;
    for (int i = envelopes.length - 1; i > 0; i--) {
      for (int j = i - 1; j >= 0; j--) {
        if (envelopes[j][0] > envelopes[i][0] && envelopes[j][1] > envelopes[i][1]) {
          max[j] = Math.max(max[j], max[i] + 1);
          totalMax = Math.max(max[j], totalMax);
        }
      }
    }
    return totalMax;
  }

  public static void main(String[] args) {
    final int[][] envelopes = {
        {10, 14}, {18, 3}, {17, 4}, {9, 6}, {3, 7}
    };
    System.out.println(new RussianDollEnvelopes().maxEnvelopes(envelopes));
  }
}
