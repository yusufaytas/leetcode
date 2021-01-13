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
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.

Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/
public class TrappingRainWater {

  public static void main(String[] args) {
    final int[] height = {9, 8, 2, 6};
    System.out.println(new TrappingRainWater().trap(height));
  }

  public int trap(int[] height) {
    int totalTrapped = 0;
    for (int i = 0; i < height.length; i++) {
      int max = 0, localMaxIndex = i, maxSoFar = 0;
      int removals = 0;
      for (int j = i + 1; j < height.length; j++) {
        if (height[j] > maxSoFar) {
          maxSoFar = height[j];
        }
        if (height[j] > 0) {
          final int localMax = ((j - i - 1) * Math.min(height[i], height[j])) - removals;
          if (localMax > max && height[j] == maxSoFar) {
            max = localMax;
            localMaxIndex = j;
          }
          removals += height[j];
        }
        if (height[j] >= height[i]) {
          i = j - 1;
          break;
        }
      }
      if (max > 0) {
        totalTrapped += max;
        i = localMaxIndex - 1;
      }
    }
    return totalTrapped;
  }
}
