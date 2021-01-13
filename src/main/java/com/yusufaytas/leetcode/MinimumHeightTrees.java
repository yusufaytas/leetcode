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

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
    while (graph.size() > 2) {
      final List<Entry<Integer, Set<Integer>>> entries = graph.entrySet().stream()
          .filter(e -> e.getValue().size() <= 1)
          .collect(Collectors.toList());
      for (final Entry<Integer, Set<Integer>> entry : entries) {
        graph.remove(entry.getKey());
        graph.get(entry.getValue().stream().findAny().get()).remove(entry.getKey());
      }
    }
    return graph.keySet().stream().collect(Collectors.toList());
  }

  public static void main(String[] args) {
    final int n = 7;
    final int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
    System.out.println(new MinimumHeightTrees().findMinHeightTrees(n, edges));
  }
}
