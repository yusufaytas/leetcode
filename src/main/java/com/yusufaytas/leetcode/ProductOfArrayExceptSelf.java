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
