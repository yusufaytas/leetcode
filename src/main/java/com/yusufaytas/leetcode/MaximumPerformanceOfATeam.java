package com.yusufaytas.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
There are n engineers numbered from 1 to n and two arrays: speed and efficiency,
where speed[i] and efficiency[i] represent the speed and efficiency for the i-th engineer respectively.
Return the maximum performance of a team composed of at most k engineers, since the answer can be a huge number, return this modulo 10^9 + 7.

The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among their engineers.

Example 1:

Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
Output: 60
Explanation:
We have the maximum performance of the team by selecting engineer 2
(with speed=10 and efficiency=4) and engineer 5 (with speed=5 and efficiency=7). That is, performance = (10 + 5) * min(4, 7) = 60.

Example 2:

Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
Output: 68
Explanation:
This is the same example as the first but k = 3. We can select engineer 1,
engineer 2 and engineer 5 to get the maximum performance of the team. That is, performance = (2 + 10 + 5) * min(5, 4, 7) = 68.

Example 3:

Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4
Output: 72

 */
public class MaximumPerformanceOfATeam {

  public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
    if (speed == null || speed.length == 0 || efficiency == null || efficiency.length == 0) {
      return 0;
    }
    final Map<Set<Integer>, Integer> visited = new HashMap<>();
    maxPerformance(speed, efficiency, new HashSet<>(),
        IntStream.range(0, efficiency.length).boxed().collect(
            Collectors.toCollection(LinkedList::new)), k, visited);
    return visited.values().stream().max(Integer::compareTo).get();
  }

  public void maxPerformance(final int[] speed, final int[] efficiency, final Set<Integer> current,
      final List<Integer> remaining, final int k, final Map<Set<Integer>, Integer> visited) {
    if (k < 0 || visited.containsKey(current)) {
      return;
    }
    if (current.size() > 0) {
      int speedSum = 0;
      int minEfficiency = Integer.MAX_VALUE;
      for (final int index : current) {
        speedSum += speed[index];
        minEfficiency = Math.min(minEfficiency, efficiency[index]);
      }
      visited.put(new HashSet<>(current), speedSum * minEfficiency);
    }
    for (int i = 0; i < remaining.size(); i++) {
      final int index = remaining.remove(i);
      current.add(index);
      maxPerformance(speed, efficiency, current, remaining, k - 1, visited);
      current.remove(index);
      remaining.add(i, index);
    }
  }

  public static void main(String[] args) {
    final int n = 4, k = 3;
    final int[] speed = {2, 10, 3, 1, 5, 8};
    final int[] efficiency = {5, 4, 3, 9, 7, 2};
    System.out.println(new MaximumPerformanceOfATeam().maxPerformance(n, speed, efficiency, k));
  }
}
