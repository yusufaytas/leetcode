package com.yusufaytas.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.


 */
public class JumpGame {

  public static void main(String[] args) {
    int nums[] = {1, 1, 2, 2, 0, 1, 1};
    System.out.println(new JumpGame().canJump(nums));
  }

  public boolean canJump(final int[] nums) {
    if (nums.length == 0) {
      return true;
    }
    final Stack<Integer> jumps = new Stack<>();
    final Set<Integer> visited = new HashSet<>();
    jumps.push(0);
    while (!jumps.isEmpty()) {
      final int current = jumps.pop();
      if (current == nums.length - 1) {
        return true;
      }
      for (int i = 1; i <= nums[current]; i++) {
        final int nextIndex = current + i;
        if (nextIndex >= nums.length - 1) {
          return true;
        }
        if (nums[nextIndex] > nums[current] - i) {
          visited.add(nextIndex);
          jumps.push(nextIndex);
        }
        if (visited.contains(nextIndex)) {
          continue;
        }
      }
    }
    return false;
  }
}
