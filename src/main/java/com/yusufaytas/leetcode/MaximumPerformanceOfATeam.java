package com.yusufaytas.leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
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
    final List<Integer> sortedEfficiencies = IntStream.range(0, speed.length).boxed()
        .sorted(Comparator.comparingInt(o -> efficiency[(int) o]).reversed())
        .collect(Collectors.toList());
    final Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> speed[o]));

    long max = 0, currentSum = 0, currentMin = Integer.MAX_VALUE;
    for (int i = 0; i < sortedEfficiencies.size(); i++) {
      if (queue.size() == k) {
        final int removalIndex = queue.poll();
        currentSum -= speed[removalIndex];
      }
      queue.add(sortedEfficiencies.get(i));
      currentSum += speed[sortedEfficiencies.get(i)];
      currentMin = Math.min(efficiency[sortedEfficiencies.get(i)], currentMin);
      max = Math.max(currentSum * currentMin, max);
    }
    return (int) (max % (Math.pow(10, 9) + 7));
  }

  public static void main(String[] args) {
    final int n = 4, k = 4;
    final int[] speed = {2, 10, 3, 1, 5, 8};
    final int[] efficiency = {5, 4, 3, 9, 7, 2};
    System.out.println(new MaximumPerformanceOfATeam().maxPerformance(n, speed, efficiency, k));
  }
}
