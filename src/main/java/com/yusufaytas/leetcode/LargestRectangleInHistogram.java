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

public class LargestRectangleInHistogram {

  public static void main(String[] args) {
    int nums[] = {2, 1, 5, 6, 2, 3};
    System.out.println(new LargestRectangleInHistogram().largestRectangleArea(nums));
  }

  public int largestRectangleArea(final int[] heights) {
    int max = 0;
    for (int i = 0; i < heights.length; i++) {
      int maxPossibleHeight = heights[i];
      max = Math.max(max, maxPossibleHeight);
      for (int j = i + 1; j < heights.length; j++) {
        if (maxPossibleHeight > heights[j]) {
          maxPossibleHeight = heights[j];
        }
        max = Math.max(max, maxPossibleHeight * (j - i + 1));
      }
    }
    return max;
  }
}
