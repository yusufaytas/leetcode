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
