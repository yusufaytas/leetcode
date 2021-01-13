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

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations:
get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

 */
public class LRUCache {

  final Map<Integer, Node> map = new HashMap<>();
  final int capacity;
  Node head, tail;

  public LRUCache(final int capacity) {
    this.capacity = capacity;
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
    System.out.println(cache.get(2));       // returns 1
    cache.put(2, 6);    // evicts key 2
    System.out.println(cache.get(1));       // returns -1 (not found)
    cache.put(1, 5);    // evicts key 1
    cache.put(1, 2);    // evicts key 1
    System.out.println(cache.get(1));       // returns -1 (not found)
    System.out.println(cache.get(2));       // returns 3
  }

  public int get(final int key) {
    if (map.containsKey(key)) {
      final Node node = map.get(key);
      removeLink(node);
      put(key, node.value);
      return node.value;
    }
    return -1;
  }

  public void put(final int key, final int value) {
    if (map.containsKey(key)) {
      removeLink(map.get(key));
    } else if (map.size() == capacity) {
      map.remove(tail.key);
      tail = tail.prev;
      if (tail != null) {
        tail.next = null;
      }
    }
    final Node newNode = new Node();
    newNode.next = head;
    newNode.value = value;
    newNode.key = key;
    if (head != null) {
      head.prev = newNode;
    }
    head = newNode;
    if (tail == null) {
      tail = head;
    }
    map.put(key, newNode);
  }

  private void removeLink(final Node node) {
    if (node.prev != null) {
      node.prev.next = node.next;
    } else {
      head = node.next;
    }
    if (node.next != null) {
      node.next.prev = node.prev;
    } else {
      tail = node.prev;
    }
  }

  private class Node {

    int key;
    int value;
    Node next;
    Node prev;
  }

}
