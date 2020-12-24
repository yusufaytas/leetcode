package com.yusufaytas.leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
There are N workers.  The i-th worker has a quality[i] and a minimum wage expectation wage[i].

Now we want to hire exactly K workers to form a paid group.
When hiring a group of K workers, we must pay them according to the following rules:

    Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
    Every worker in the paid group must be paid at least their minimum wage expectation.

Return the least amount of money needed to form a paid group satisfying the above conditions.

Example 1:

Input: quality = [10,20,5], wage = [70,50,30], K = 2
Output: 105.00000
Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.

Example 2:

Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
Output: 30.66667
Explanation: We pay 4 to 0-th worker, 13.33333 to 2-th and 3-th workers separately.

 */
public class MinimumCostToHireKWorkers {

  public double minCostToHireWorkers(int[] quality, int[] wage, int k) {
    if (quality == null || quality.length == 0 || wage == null || wage.length == 0) {
      return 0;
    }
    final double[] ratios = new double[wage.length];
    for (int i = 0; i < quality.length; i++) {
      ratios[i] = wage[i] / (double) quality[i];
    }
    final List<Integer> ratioSortedIndexes = IntStream.range(0, wage.length).boxed()
        .sorted(Comparator.comparingDouble(o -> ratios[o]))
        .collect(Collectors.toList());

    final Queue<Integer> maxQuality = new PriorityQueue<>(
        Comparator.comparingInt(value -> -quality[value]));

    double maxRatio = 0;
    double qualitySum = 0;
    for (int i = 0; i < k; i++) {
      qualitySum += quality[ratioSortedIndexes.get(i)];
      maxQuality.add(ratioSortedIndexes.get(i));
      maxRatio = Math.max(ratios[ratioSortedIndexes.get(i)], maxRatio);
    }
    double min = qualitySum * maxRatio;

    for (int i = k; i < wage.length; i++) {
      qualitySum -= quality[maxQuality.poll()];
      maxRatio = Math.max(ratios[ratioSortedIndexes.get(i)], maxRatio);
      maxQuality.add(ratioSortedIndexes.get(i));
      qualitySum += quality[ratioSortedIndexes.get(i)];
      min = Math.min(qualitySum * maxRatio, min);
    }

    return min;
  }

  public double totalWages(final int[] quality, final List<Integer> indexes, double maxRatio) {
    double sum = 0;
    for (final int index : indexes) {
      sum += maxRatio * quality[index];
    }
    return sum;
  }

  public static void main(String[] args) {
    final int[] quality = {2, 1, 5};
    final int[] wage = {17, 6, 4};
    final int k = 2;
    System.out.println(new MinimumCostToHireKWorkers().minCostToHireWorkers(quality, wage, k));
  }
}
