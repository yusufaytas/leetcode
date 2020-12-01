package com.yusufaytas.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Combinations {

  public static void main(String[] args) {
    System.out.println(new Combinations().combine(20, 16));
  }

  public List<List<Integer>> combine(final int n, final int k) {
    final Set<Set<Integer>> all = new HashSet<>();
    final Set<Integer> current = new HashSet<>();
    for (int i = 0; i < n; i++) {
      current.add(i + 1);
    }
    combine(all, current, new HashSet(), n, k);
    return all.stream()
        .map(ints -> ints.stream().collect(Collectors.toList()))
        .collect(Collectors.toList());
  }

  public void combine(final Set<Set<Integer>> all,
      final Set<Integer> current,
      final Set<Set<Integer>> seen,
      final int n,
      final int k) {
    if (n == k) {
      all.add(current);
      return;
    }
    if (!seen.add(current)) {
      return;
    }
    for (final int e : current) {
      final Set<Integer> newCurrent = new HashSet<>();
      newCurrent.addAll(current);
      newCurrent.remove(e);
      combine(all, newCurrent, seen, n - 1, k);
    }
  }
}
