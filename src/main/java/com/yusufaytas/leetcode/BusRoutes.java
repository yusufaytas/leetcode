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

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever.
For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels
in the sequence 1->5->7->1->5->7->1->... forever.

We start at bus stop S (initially not on a bus), and we want to go to bus stop T.
Travelling by buses only, what is the least number of buses we must take
to reach our destination? Return -1 if it is not possible.

Example:
Input:
routes = [[1, 2, 7], [3, 6, 7]]
S = 1
T = 6
Output: 2
Explanation:
The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.

 */
public class BusRoutes {

  public int numBusesToDestination(final int[][] routes, final int S, final int T) {
    final Map<Integer, Set<Integer>> busToStops = new HashMap<>();
    final Map<Integer, Set<Integer>> stopToBuses = new HashMap<>();
    for (int i = 0; i < routes.length; i++) {
      final Set<Integer> stops = new HashSet<>();
      for (final int stop : routes[i]) {
        stopToBuses.putIfAbsent(stop, new HashSet<>());
        stopToBuses.get(stop).add(i);
        stops.add(stop);
      }
      busToStops.put(i, stops);
    }
    final Queue<BusStop> stops = new ArrayDeque<>();
    final Set<Integer> visitedStops = new HashSet<>();
    stops.add(new BusStop(S, 0));
    while (!stops.isEmpty()) {
      final BusStop currentStop = stops.poll();
      if (!visitedStops.add(currentStop.stop)) {
        continue;
      }
      if (currentStop.stop == T) {
        return currentStop.count;
      }
      for (final int bus : stopToBuses.get(currentStop.stop)) {
        for (final int nextStop : busToStops.get(bus)) {
          stops.add(new BusStop(nextStop, currentStop.count + 1));
        }
      }
    }
    return -1;
  }

  static class BusStop {

    final int stop;
    final int count;

    BusStop(final int stop, final int count) {
      this.stop = stop;
      this.count = count;
    }
  }

  public static void main(String[] args) {
    final int[][] routes = {{1, 2, 7}, {3, 6, 7, 8}, {6, 8}};
    final int S = 1, T = 8;
    System.out.println(new BusRoutes().numBusesToDestination(routes, S, T));
  }
}
