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

import java.util.HashMap;
import java.util.Map;

class Trie {

  private boolean isWord = false;
  private Map<Character, Trie> nodes = new HashMap<>();

  public Trie() {
  }

  public void insert(String word) {
    Trie currentNode = this;
    for (int i = 0; i < word.length(); i++) {
      char value = word.charAt(i);
      if (!currentNode.nodes.containsKey(value)) {
        Trie newNode = new Trie();
        currentNode.nodes.put(value, newNode);
        currentNode = newNode;
      } else {
        currentNode = currentNode.nodes.get(value);
      }
    }
    currentNode.isWord = true;
  }

  public boolean search(String word) {
    Trie trie = findWord(word);
    return trie != null && trie.isWord;
  }

  public boolean startsWith(String prefix) {
    Trie trie = findWord(prefix);
    return trie != null;
  }

  public Trie findWord(String word) {
    Trie currentNode = this;
    for (int i = 0; i < word.length(); i++) {
      char value = word.charAt(i);
      if (currentNode.nodes.containsKey(value)) {
        currentNode = currentNode.nodes.get(value);
      } else {
        return null;
      }
    }
    return currentNode;
  }
}

