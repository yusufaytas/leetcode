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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w),
where u is the source node, v is the target node, and w is the time it takes
for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes
to receive the signal? If it is impossible, return -1.

Example 1:

Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
Output: 2
 */
public class NetworkDelayTime {

  public int networkDelayTime(final int[][] times, final int N, final int K) {
    if (times == null || times.length == 0) {
      return -1;
    }
    final int[] paths = new int[N + 1];
    Arrays.fill(paths, Integer.MAX_VALUE);
    final Map<Integer, List<int[]>> graph = new HashMap<>();
    for (int i = 0; i < times.length; i++) {
      if (!graph.containsKey(times[i][0])) {
        graph.put(times[i][0], new ArrayList<>());
      }
      graph.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
    }
    final Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> paths[o]));
    paths[K] = 0;
    queue.add(K);
    while (!queue.isEmpty()) {
      final int node = queue.poll();
      final List<int[]> neighbours = graph.get(node);
      if (neighbours == null) {
        continue;
      }
      for (int i = 0; i < neighbours.size(); i++) {
        final int neighbour = neighbours.get(i)[0];
        final int weight = neighbours.get(i)[1];
        if (paths[node] + weight < paths[neighbour]) {
          paths[neighbour] = paths[node] + weight;
          queue.add(neighbour);
        }
      }
    }
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < paths.length; i++) {
      max = Math.max(max, paths[i]);
    }
    return max == Integer.MAX_VALUE ? -1 : max;
  }

  public static void main(String[] args) {
    final int[][] times = {
        {2, 1, 1}, {2, 3, 1}, {3, 4, 1}
    };
    final int N = 4, K = 2;
    System.out.println(new NetworkDelayTime().networkDelayTime(times, N, K));
  }
}
