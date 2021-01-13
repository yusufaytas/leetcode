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
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

 */
public class NextPermutation {

  public static void main(String[] args) {
    final int[] nums = {1, 3, 2};
    new NextPermutation().nextPermutation(nums);
    System.out.println(
        Arrays.stream(nums).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(",")));
  }

  public void swap(final int[] nums, final int i, final int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public void nextPermutation(final int[] nums) {
    for (int i = nums.length - 1; i >= 0; i--) {
      int localMinIndex = i;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] > nums[i] && (nums[j] < nums[localMinIndex] || localMinIndex == i)) {
          localMinIndex = j;
        }
      }
      if (localMinIndex != i) {
        swap(nums, localMinIndex, i);
        Arrays.sort(nums, i + 1, nums.length);
        return;
      }
    }
    Arrays.sort(nums);
  }
}
