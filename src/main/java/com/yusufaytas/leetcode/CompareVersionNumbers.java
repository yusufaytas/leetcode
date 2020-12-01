package com.yusufaytas.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Given two version numbers, version1 and version2, compare them.

Version numbers consist of one or more revisions joined by a dot '.'.
Each revision consists of digits and may contain leading zeros. Every revision contains
at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0,
the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.

To compare version numbers, compare their revisions in left-to-right order.
Revisions are compared using their integer value ignoring any leading zeros.
This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index,
then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same,
but their revision 1s are 0 and 1 respectively, and 0 < 1.

Return the following:

    If version1 < version2, return -1.
    If version1 > version2, return 1.
    Otherwise, return 0.



Example 1:

Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".

Example 2:

Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: version1 does not specify revision 2, which means it is treated as "0".

Example 3:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.

Example 4:

Input: version1 = "1.0.1", version2 = "1"
Output: 1

Example 5:

Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1

 */
public class CompareVersionNumbers {

  public static void main(String[] args) {
    final String v1 = "1.0.1";
    final String v2 = "1.01";
    System.out.println(new CompareVersionNumbers().compareVersion(v1, v2));
  }

  public int compareVersion(final String version1, final String version2) {
    final Queue<Integer> v1 = Stream.of(version1.split("\\."))
        .map(s -> Integer.parseInt(s))
        .collect(Collectors.toCollection(LinkedList::new));

    final Queue<Integer> v2 = Stream.of(version2.split("\\."))
        .map(s -> Integer.parseInt(s))
        .collect(Collectors.toCollection(LinkedList::new));

    while (!v1.isEmpty() && !v2.isEmpty()) {
      int currentV1 = v1.poll();
      int currentV2 = v2.poll();
      if (currentV1 > currentV2) {
        return 1;
      } else if (currentV2 > currentV1) {
        return -1;
      }
    }
    while (!v1.isEmpty() && v1.peek() == 0) {
      v1.poll();
    }
    while (!v2.isEmpty() && v2.peek() == 0) {
      v2.poll();
    }
    if (v1.size() > v2.size()) {
      return 1;
    } else if (v2.size() > v1.size()) {
      return -1;
    }
    return 0;
  }
}
