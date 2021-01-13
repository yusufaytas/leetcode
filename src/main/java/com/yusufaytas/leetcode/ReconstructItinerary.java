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
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
 reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus,
 the itinerary must begin with JFK.

Note:

    If there are multiple valid itineraries, you should return the itinerary that has the smallest
    lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller
    lexical order than ["JFK", "LGB"].
    All airports are represented by three capital letters (IATA code).
    You may assume all tickets form at least one valid itinerary.
    One must use all the tickets once and only once.

Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.


 */
public class ReconstructItinerary {

  public List<String> findItinerary(final List<List<String>> tickets) {
    if (tickets == null || tickets.isEmpty()) {
      return Collections.emptyList();
    }
    final Map<String, List<String>> flights = new HashMap<>();
    for (final List<String> ticket : tickets) {
      if (!flights.containsKey(ticket.get(0))) {
        flights.put(ticket.get(0), new LinkedList<>());
      }
      flights.get(ticket.get(0)).add(ticket.get(1));
    }
    for (final List<String> v : flights.values()) {
      Collections.sort(v);
    }
    final List<String> itinerary = new ArrayList<>();
    itinerary.add("JFK");
    findItinerary("JFK", tickets.size() + 1, flights, itinerary);
    return itinerary;
  }

  private boolean findItinerary(final String current, final int size,
      final Map<String, List<String>> flights, final List<String> itinerary) {
    if (itinerary.size() == size) {
      return true;
    }
    final List<String> toFlights = flights.get(current);
    if (toFlights != null && toFlights.size() > 0) {
      for (int i = 0; i < toFlights.size(); i++) {
        final String next = toFlights.remove(i);
        itinerary.add(next);
        if (findItinerary(next, size, flights, itinerary)) {
          return true;
        }
        itinerary.remove(itinerary.size() - 1);
        toFlights.add(i, next);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    final List<List<String>> tickets = Arrays.asList(
        Arrays.asList("JFK", "KUL"),
        Arrays.asList("JFK", "NRT"),
        Arrays.asList("NRT", "JFK"));
    System.out.println(new ReconstructItinerary().findItinerary(tickets));
  }
}
