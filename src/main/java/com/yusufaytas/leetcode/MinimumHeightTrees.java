package com.yusufaytas.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/*
A tree is an undirected graph in which any two vertices are connected by exactly one path.
In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges
where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes
ai and bi in the tree, you can choose any node of the tree as the root. When you select a node
x as the root, the result tree has height h. Among all possible rooted trees, those with
minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

Example 1:

Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.

Example 2:

Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]

Example 3:

Input: n = 1, edges = []
Output: [0]

Example 4:

Input: n = 2, edges = [[0,1]]
Output: [0,1]

 */
public class MinimumHeightTrees {

  public List<Integer> findMinHeightTrees(final int n, final int[][] edges) {
    if (edges == null || edges.length == 0) {
      return Arrays.asList(0);
    }
    final int[][] distance = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(distance[i], -1);
    }
    final Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int i = 0; i < edges.length; i++) {
      if (!graph.containsKey(edges[i][0])) {
        graph.put(edges[i][0], new HashSet<>());
      }
      if (!graph.containsKey(edges[i][1])) {
        graph.put(edges[i][1], new HashSet<>());
      }
      graph.get(edges[i][0]).add(edges[i][1]);
      graph.get(edges[i][1]).add(edges[i][0]);
      distance[i][edges[i][0]] = 0;
      distance[0][edges[i][0]] = 0;
    }
    final Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
    for (int i = 0; i < n; i++) {
      queue.add(new int[]{i, i, 0});
    }
    while (!queue.isEmpty()) {
      final int[] tuple = queue.poll();
      final int root = tuple[0];
      final int node = tuple[1];
      final int height = tuple[2];
      distance[root][node] = height;
      distance[node][root] = height;
      for (final int neighbour : graph.get(node)) {
        if (distance[neighbour][root] == -1) {
          queue.add(new int[]{root, neighbour, height + 1});
        }
      }
    }
    final Map<Integer, Integer> minHeightTreeRoots = new HashMap<>();
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < distance.length; i++) {
      int max = 0;
      for (int j = 0; j < distance.length; j++) {
        max = Math.max(max, distance[i][j]);
      }
      min = Math.min(max, min);
      minHeightTreeRoots.put(i, max);
    }
    final int finalMin = min;
    return minHeightTreeRoots.entrySet().stream()
        .filter(e -> e.getValue() == finalMin)
        .map(value -> value.getKey())
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    final int n = 7;
    final int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}};
    System.out.println(new MinimumHeightTrees().findMinHeightTrees(n, edges));
  }
}
