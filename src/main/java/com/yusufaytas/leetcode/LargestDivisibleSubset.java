package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Given a set of distinct positive integers, find the largest subset such that every pair
(Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)

Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]

 */
public class LargestDivisibleSubset {

  public List<Integer> largestDivisibleSubset(int[] nums) {
    if (nums == null || nums.length == 0) {
      return Collections.emptyList();
    }
    return largestDivisibleSubset(new HashSet<>(),
        IntStream.of(nums).boxed().collect(Collectors.toList()));
  }

  public List<Integer> largestDivisibleSubset(final Set<Integer> current,
      final List<Integer> remaining) {
    if (remaining.isEmpty()) {
      return new ArrayList<>(current);
    }
    List<Integer> largestSoFar = Collections.emptyList();
    for (int i = 0; i < remaining.size(); i++) {
      final int num = remaining.get(i);
      final boolean isDivisible = isDivisible(current, num);
      if (isDivisible) {
        current.add(num);
      }
      remaining.remove(i);
      final List<Integer> largest = largestDivisibleSubset(current, remaining);
      if (largest.size() > largestSoFar.size()) {
        largestSoFar = largest;
      }
      remaining.add(i, num);
      if (isDivisible) {
        current.remove(num);
      }
    }
    return largestSoFar;
  }

  public boolean isDivisible(final Set<Integer> nums, final int nextNum) {
    for (final int num : nums) {
      if (num % nextNum != 0 && nextNum % num != 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, 5, 7, 11, 13, 17, 19, 23, 31, 1000000007};
    System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(nums));
  }
}
