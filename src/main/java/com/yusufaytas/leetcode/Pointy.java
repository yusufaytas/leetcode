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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pointy {

  public boolean hasDuplicate(int[] nums) {
    Set<Integer> numSet = new HashSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
      int current = nums[i];
      if (numSet.contains(current)) {
        return true;
      }
      numSet.add(current);
    }
    return false;
  }

  // ab ab
  public List<List<String>> anagrams(String[] strings) {
    List<HashMap<Character, Integer>> list = new ArrayList<HashMap<Character, Integer>>();
    for (int i = 0; i < strings.length; i++) {
      String current = strings[i];
      HashMap<Character, Integer> currentMap = new HashMap<Character, Integer>();
      list.add(currentMap);
      for (int j = 0; j < current.length(); j++) {
        char c = current.charAt(j);
        if (currentMap.containsKey(c)) {
          currentMap.put(c, currentMap.get(c) + 1);
        } else {
          currentMap.put(c, 1);
        }
      }
    }
    List<List<String>> anagrams = new ArrayList<List<String>>();
    for (int i = 0; i < list.size(); i++) {
      for (int j = i + 1; j < list.size(); j++) {
        boolean isFound = true;
        HashMap<Character, Integer> iMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> jMap = new HashMap<Character, Integer>();

        if (!iMap.keySet().equals(jMap.keySet())) {
          break;
        }

        for (Character character : iMap.keySet()) {
          if (jMap.get(character) != iMap.get(character)) {
            isFound = false;
            break;
          }

        }
        if (isFound) {
          List<String> currentAnagram = new ArrayList<String>();
          currentAnagram.add(strings[i]);
          currentAnagram.add(strings[j]);
          anagrams.add(currentAnagram);
        }
      }
    }
    return anagrams;
  }

}
