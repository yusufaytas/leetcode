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
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
You are given an integer array nums and you have to return a new counts array.
The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

 */
public class CountOfSmallerNumbersAfterSelf {

  public List<Integer> countSmaller(final int[] nums) {
    if (nums == null || nums.length == 0) {
      return Collections.emptyList();
    }
    final List<Integer> greater = new LinkedList<>();
    final List<Double> sortedNums = new ArrayList<>();
    for (int i = nums.length - 1; i >= 0; i--) {
      final int index = Math.abs(Collections.binarySearch(sortedNums, nums[i] - 0.5) + 1);
      sortedNums.add(index, (double) nums[i]);
      greater.add(0, index);
    }
    return greater;
  }

  public static void main(String[] args) {
    int[] nums = {26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81,
        32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41};
    System.out.println(new CountOfSmallerNumbersAfterSelf().countSmaller(nums));
  }
}
