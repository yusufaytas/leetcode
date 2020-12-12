package com.yusufaytas.leetcode;

/*
You are given a sorted array consisting of only integers where every element appears exactly twice,
except for one element which appears exactly once. Find this single element that appears only once.

Follow up: Your solution should run in O(log n) time and O(1) space.

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10

Constraints:

    1 <= nums.length <= 10^5
    0 <= nums[i] <= 10^5

 */
public class SingleElementInASortedArray {

  public int singleNonDuplicate(final int[] nums) {
    if (nums == null || nums.length == 0 || nums.length % 2 == 0) {
      return -1;
    }
    int start = 0, end = nums.length / 2;
    while (start < end) {
      final int mid = (end + start) / 2;
      final int midIndex = mid * 2;
      if ((midIndex == nums.length - 1 && nums[midIndex] != nums[midIndex - 1])
          || (midIndex == 0 && nums[midIndex] != nums[midIndex + 1])
          || (midIndex - 1 >= 0
          && midIndex + 1 < nums.length && nums[midIndex] != nums[midIndex + 1]
          && nums[midIndex] != nums[midIndex - 1])) {
        return nums[midIndex];
      }
      if (nums[midIndex] == nums[midIndex + 1]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return nums[end * 2];
  }

  public static void main(String[] args) {
    final int[] nums = {3,3,7,7,10,11,11};
    System.out.println(new SingleElementInASortedArray().singleNonDuplicate(nums));
  }
}
