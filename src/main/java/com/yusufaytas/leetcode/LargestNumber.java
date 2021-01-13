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
import java.util.stream.Collectors;

/*
Given a list of non-negative integers nums, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.

Example 1:

Input: nums = [10,2]
Output: "210"

Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"

Example 3:

Input: nums = [1]
Output: "1"

Example 4:

Input: nums = [10]
Output: "10"

 */
public class LargestNumber {

  public static void main(String[] args) {
    final int[] nums = new int[]{0, 0};
    System.out.println(new LargestNumber().largestNumber(nums));
  }

  public String largestNumber(final int[] nums) {
    if (nums == null || nums.length == 0) {
      return "";
    }
    final String number = Arrays.stream(nums).mapToObj(i -> Integer.toString(i))
        .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
        .collect(Collectors.joining(""));
    if (number.startsWith("0")) {
      return "0";
    }
    return number;
  }
}
