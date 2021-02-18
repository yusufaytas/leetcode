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
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.
A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

Example 1:

Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
"dogcatsdog" can be concatenated by "dog", "cats" and "dog";
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".

Example 2:

Input: words = ["cat","dog","catdog"]
Output: ["catdog"]
 */
public class ConcatenatedWords {

  public List<String> findAllConcatenatedWordsInADict(final String[] words) {
    if (words == null || words.length == 0) {
      return Collections.emptyList();
    }
    Arrays.sort(words);
    final Set<String> wordSet = Stream.of(words).filter(w -> !w.isEmpty())
        .collect(Collectors.toSet());
    final List<String> concatenatedWords = new ArrayList<>();
    final Map<String, Boolean> visited = new HashMap<>();
    for (final String word : words) {
      if (!word.isEmpty() && isConcatenatedWord(visited, wordSet, word, 0)) {
        concatenatedWords.add(word);
      }
    }
    return concatenatedWords;
  }

  public boolean isConcatenatedWord(final Map<String, Boolean> visited, final Set<String> words,
      final String word, final int index) {
    if (index == word.length()) {
      return true;
    }
    if (visited.containsKey(word.substring(index)) && index > 0) {
      return visited.get(word.substring(index));
    }
    String temp = "";
    for (int i = index; i < word.length(); i++) {
      temp += word.charAt(i);
      if (words.contains(temp) && !temp.equals(word)
          && isConcatenatedWord(visited, words, word, i + 1)) {
        visited.put(word.substring(i + 1), true);
        return true;
      }
    }
    if (index > 0) {
      visited.put(word.substring(index), false);
    }
    return false;
  }

  public static void main(String[] args) {
    final String[] words = {"cat", "cats", "catsdogcats", "dog"};
    System.out.println(new ConcatenatedWords().findAllConcatenatedWordsInADict(words));
  }
}
