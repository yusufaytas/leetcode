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

public class ThirdMaximumNumber {

  public static void main(String[] args) {
    final int[] nums = {3, 2, 1};
    System.out.println(new ThirdMaximumNumber().thirdMax(nums));
  }

  public int thirdMax(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
    final Set<Integer> seen = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (!seen.add(nums[i])) {
        continue;
      }
      if (nums[i] > first) {
        third = second;
        second = first;
        first = nums[i];
      } else if (nums[i] > second) {
        third = second;
        second = nums[i];
      } else if (nums[i] > third) {
        third = nums[i];
      }
    }
    if (seen.size() < 3) {
      return first;
    }
    return third;
  }
}
