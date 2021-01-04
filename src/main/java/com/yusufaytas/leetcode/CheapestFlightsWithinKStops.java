package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst,
your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input:
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.

Example 2:
Input:
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.

 */
public class CheapestFlightsWithinKStops {

  public int findCheapestPrice(final int n, final int[][] flights,
      final int src, final int dst, final int K) {
    final Map<Integer, List<List<Integer>>> graph = new HashMap<>();
    for (int i = 0; i < flights.length; i++) {
      final List<List<Integer>> edges = graph.getOrDefault(flights[i][0], new ArrayList<>());
      if (edges.isEmpty()) {
        graph.put(flights[i][0], edges);
      }
      edges.add(Arrays.asList(flights[i][1], flights[i][2]));
    }
    final Queue<List<Integer>> queue = new PriorityQueue<>(
        Comparator.comparingInt(value -> value.get(2)));
    queue.add(Arrays.asList(src, -1, 0));
    final Map<Integer, Integer> visited = new HashMap();
    while (!queue.isEmpty()) {
      final List<Integer> current = queue.poll();
      final int node = current.get(0);
      final int nextLevel = current.get(1) + 1;
      final int cost = current.get(2);
      if (node == dst) {
        return cost;
      }
      if (!graph.containsKey(node) || visited.getOrDefault(node, Integer.MAX_VALUE) <= nextLevel) {
        continue;
      }
      visited.put(node, nextLevel);
      for (final List<Integer> edge : graph.get(node)) {
        if (nextLevel <= K) {
          queue.add(Arrays.asList(edge.get(0), nextLevel, edge.get(1) + cost));
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    final int n = 3, src = 0, dst = 3, K = 1;
    final int[][] flights = {
        {0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}
    };
    System.out
        .println(new CheapestFlightsWithinKStops().findCheapestPrice(n, flights, src, dst, K));
  }
}
