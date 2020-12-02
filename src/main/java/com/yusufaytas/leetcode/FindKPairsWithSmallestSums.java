package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/*
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence:
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [1,1],[1,1]
Explanation: The first 2 pairs are returned from the sequence:
             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [1,3],[2,3]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 */

public class FindKPairsWithSmallestSums {

  public List<List<Integer>> kSmallestPairs(final int[] nums1, final int[] nums2, final int k) {
    if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
      return Collections.emptyList();
    }
    final List<List<Integer>> pairs = new ArrayList<>();
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        pairs.add(Arrays.asList(nums1[i], nums2[j]));
      }
    }
    return pairs.stream()
        .sorted(Comparator.comparingInt(o -> o.get(0) + o.get(1)))
        .limit(k)
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    final int[] nums1 = {1, 2, 4};
    final int[] nums2 = {-1, 1, 2};
    System.out.println(new FindKPairsWithSmallestSums().kSmallestPairs(nums1, nums2, 9));
  }
}
