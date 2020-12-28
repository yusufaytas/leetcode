package com.yusufaytas.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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
    }
    final int[] heights = new int[n];
    int min = n - 1;
    for (int i = 0; i < heights.length; i++) {
      heights[i] = findHeight(i, graph);
      min = Math.min(heights[i], min);
    }
    final List<Integer> minHeightTreeRoots = new ArrayList<>();
    for (int i = 0; i < heights.length; i++) {
      if (heights[i] == min) {
        minHeightTreeRoots.add(i);
      }
    }
    return minHeightTreeRoots;
  }

  private int findHeight(final int root, final Map<Integer, Set<Integer>> graph) {
    final Set<Integer> visited = new HashSet<>();
    final Queue<int[]> remaining = new ArrayDeque<>();
    remaining.add(new int[]{root, 0});
    int max = Integer.MIN_VALUE;
    while (!remaining.isEmpty()) {
      final int[] current = remaining.poll();
      if (visited.contains(current[0])) {
        continue;
      }
      visited.add(current[0]);
      for (final int neighbour : graph.get(current[0])) {
        if (!visited.contains(neighbour)) {
          remaining.add(new int[]{neighbour, current[1] + 1});
          max = Math.max(max, current[1] + 1);
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    final int n = 1717;
    final int[][] edges = {{1, 0}};
    System.out.println(new MinimumHeightTrees().findMinHeightTrees(n, edges));
  }
}
