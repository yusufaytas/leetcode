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

import static com.yusufaytas.leetcode.Utils.printArray;

import java.util.HashMap;
import java.util.Map;

/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]

Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
    It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
    You can return the answer in any order.


 */
public class TopKFrequentElements {

  public static void main(String[] args) {
    final int[] nums = new int[]{
        1, 1, 1, 2, 2, 3
    };
    final int[] topK = new TopKFrequentElements().topKFrequent(nums, 2);
    printArray(topK);
  }

  public int[] topKFrequent(int[] nums, int k) {
    final Map<Integer, Integer> counts = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      counts.put(nums[i], counts.getOrDefault(nums[i], 0) - 1);
    }
    return counts.entrySet().stream()
        .sorted(Map.Entry.comparingByValue())
        .map(e -> e.getKey())
        .limit(k)
        .mapToInt(value -> value)
        .toArray();
  }
}
