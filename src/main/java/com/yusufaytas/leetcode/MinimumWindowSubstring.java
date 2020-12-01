package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given a string S and a string T,
find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".
If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {

  public static void main(String[] args) {
    String s = "ADOBECODEBANC";
    String t = "ABC";
    System.out.println(new MinimumWindowSubstring().minWindow(s, t));
  }

  public String minWindow(String s, String t) {
    if (t.length() > s.length()) {
      return "";
    }

    Map<Character, List<Integer>> charMap = new HashMap<>();
    Map<Character, Integer> countMap = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      charMap.put(t.charAt(i), new ArrayList<>());
      countMap.put(t.charAt(i), countMap.getOrDefault(t.charAt(i), 0) + 1);
    }
    for (int i = 0; i < s.length(); i++) {
      char value = s.charAt(i);
      if (charMap.containsKey(value)) {
        charMap.get(value).add(i);
      }
    }

    if (charMap.values().stream().anyMatch(integers -> integers.isEmpty())) {
      return "";
    }

    int[] index = new int[t.length()];

    List<List<Integer>> indexes = new ArrayList<>();
    for (Map.Entry<Character, List<Integer>> entry : charMap.entrySet()) {
      int count = countMap.get(entry.getKey());
      List<Integer> listToDivide = entry.getValue();

      if (listToDivide.size() < count) {
        return "";
      }

      List<List<Integer>> allLists = new ArrayList<>();
      for (int i = 0; i < count; i++) {
        allLists.add(new ArrayList<>());
      }
      for (int i = 0; i < listToDivide.size(); i++) {
        allLists.get(i % count).add(listToDivide.get(i));
      }
      indexes.addAll(allLists);
    }

    int max = Integer.MAX_VALUE - 1, min = 0, currentMax = Integer.MIN_VALUE;
    PriorityQueue<Integer> minQueue = new PriorityQueue<>(
        Comparator.comparingInt(o -> indexes.get(o).get(index[o])));

    for (int i = 0; i < index.length; i++) {
      minQueue.add(i);
      if (currentMax < indexes.get(i).get(0)) {
        currentMax = indexes.get(i).get(0);
      }
    }

    while (true) {
      int currentMinList = minQueue.poll();
      int currentMin = indexes.get(currentMinList).get(index[currentMinList]);
      if (currentMax - currentMin < max - min) {
        max = currentMax;
        min = currentMin;
      }

      index[currentMinList]++;
      if (index[currentMinList] >= indexes.get(currentMinList).size()) {
        break;
      }
      if (currentMax < indexes.get(currentMinList).get(index[currentMinList])) {
        currentMax = indexes.get(currentMinList).get(index[currentMinList]);
      }
      minQueue.add(currentMinList);
    }
    return s.substring(min, max + 1);
  }
}
