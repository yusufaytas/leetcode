package com.yusufaytas.leetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

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

TODO: revisit
 */
public class ShortestPathVisitingAllNodes {

  public int shortestPathLength(final int[][] graph) {
    if (graph == null || graph.length == 0) {
      return 0;
    }
    //use bit manipulation for visited
    final int ALL_VISITED = (int) (Math.pow(2, graph.length)) - 1;
    final Queue<int[]> queue = new ArrayDeque<>();
    for (int i = 0; i < graph.length; i++) {
      //the node id, bitwise visited, length
      queue.add(new int[]{i, 1 << i, 1});
    }
    final Set<String> visited = new HashSet<>();
    while (!queue.isEmpty()) {
      final int[] visit = queue.poll();
      final String visitKey = visit[0] + "." + visit[1];
      if (!visited.add(visitKey)) {
        continue;
      }
      if (visit[1] == ALL_VISITED) {
        return visit[2] - 1;
      }
      for (int i = 0; i < graph[visit[0]].length; i++) {
        final int neighbour = graph[visit[0]][i];
        queue.add(new int[]{neighbour, visit[1] | (1 << neighbour), visit[2] + 1});
      }
    }
    return -1;
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
