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
import java.util.List;

/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

 */
public class FindAllDuplicatesInArray {

  public List<Integer> findDuplicates(int[] nums) {
    final List<Integer> duplicates = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[Math.abs(nums[i]) - 1] < 0) {
        duplicates.add(Math.abs(nums[i]));
      } else {
        nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
      }
    }
    return duplicates;
  }
}
