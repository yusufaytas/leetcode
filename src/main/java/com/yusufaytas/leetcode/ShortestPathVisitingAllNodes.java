package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph.

graph.length = N, and j != i is in the list graph[i] exactly once, if and only if nodes i and j are connected.

Return the length of the shortest path that visits every node. You may start and stop at any node,
you may revisit nodes multiple times, and you may reuse edges.

Example 1:

Input: [[1,2,3],[0],[0],[0]]
Output: 4
Explanation: One possible path is [1,0,2,0,3]

Example 2:

Input: [[1],[0,2,4],[1,3,4],[2],[1,2]]
Output: 4
Explanation: One possible path is [0,1,4,2,3]

 */
public class ShortestPathVisitingAllNodes {

  public int shortestPathLength(final int[][] graph) {
    if (graph == null || graph.length == 0) {
      return 0;
    }
    final Map<Integer, List<Integer>> nodes = new HashMap<>();
    for (int i = 0; i < graph.length; i++) {
      nodes.put(i, new ArrayList<>());
      for (int j = 0; j < graph[i].length; j++) {
        nodes.get(i).add(graph[i][j]);
      }
    }
    int min = Integer.MAX_VALUE;
    final Map<Integer, Integer> visited = new HashMap<>();
    for (int i = 0; i < graph.length; i++) {
      visited.put(i, 1);
      min = Math.min(shortestPathLength(nodes, visited, i), min);
      visited.remove(i);
    }
    return min - 1;
  }

  public int shortestPathLength(final Map<Integer, List<Integer>> nodes,
      final Map<Integer, Integer> visited, final int current) {
    if (visited.size() == nodes.size()) {
      return visited.values().stream().mapToInt(value -> value).sum();
    }
    int min = Integer.MAX_VALUE;
    final List<Integer> neighbours = nodes.get(current);
    for (int i = 0; i < neighbours.size(); i++) {
      final int neighbour = neighbours.remove(i);
      visited.put(neighbour, visited.getOrDefault(neighbour, 0) + 1);
      min = Math.min(shortestPathLength(nodes, visited, neighbour), min);
      neighbours.add(i, neighbour);
      if (visited.get(neighbour) == 1) {
        visited.remove(neighbour);
      } else {
        visited.put(neighbour, visited.get(neighbour) - 1);
      }
    }
    return min;
  }

  public static void main(String[] args) {
    final int[][] graph = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
        {0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11}, {0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11},
        {0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11}, {0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11},
        {0, 1, 2, 3, 4, 5, 7, 8, 9, 10, 11}, {0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11},
        {0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11}, {0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11},
        {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11}, {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};
    System.out.println(new ShortestPathVisitingAllNodes().shortestPathLength(graph));
  }
}
