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

import static com.yusufaytas.leetcode.Utils.printArray;

/*

Given an array nums of n integers where n > 1,  return an array output such that output[i]
is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

Constraint: It's guaranteed that the product of the elements of any prefix or suffix
of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as
extra space for the purpose of space complexity analysis.)
TODO: revisit
 */
public class ProductOfArrayExceptSelf {

  public static void main(String[] args) {
    final int nums[] = {1, 2, 3, 4};
    printArray(new ProductOfArrayExceptSelf().productExceptSelf(nums));
  }

  public int[] productExceptSelf(final int[] nums) {
    final int[] product = new int[nums.length];
    if (nums == null && nums.length == 0) {
      return product;
    }
    final int[] leftProduct = new int[nums.length];
    leftProduct[0] = nums[0];
    final int[] rightProduct = new int[nums.length];
    rightProduct[nums.length - 1] = nums[nums.length - 1];
    for (int i = 1; i < nums.length; i++) {
      leftProduct[i] = nums[i] * leftProduct[i - 1];
      rightProduct[nums.length - i - 1] = nums[nums.length - i - 1] * rightProduct[nums.length - i];
    }
    for (int i = 1; i < nums.length - 1; i++) {
      product[i] = leftProduct[i - 1] * rightProduct[i + 1];
    }
    product[0] = rightProduct[1];
    product[nums.length - 1] = leftProduct[nums.length - 2];
    return product;
  }
}
