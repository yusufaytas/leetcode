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
A linked list is given such that each node contains an additional
random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes.
Each node is represented as a pair of [val, random_index] where:

    val: an integer representing Node.val
    random_index: the index of the node (range from 0 to n-1)
    where random pointer points to, or null if it does not point to any node.

 */
public class CopyListWithRandomPointer {

  public Node copyRandomList(final Node head) {
    if (head == null) {
      return null;
    }
    final Map<Node, Integer> nodeToIndex = new HashMap<>();
    final Map<Integer, Node> indexToNode = new HashMap<>();
    final Node newHead = new Node(head.val);
    Node temp = head.next, newTemp = newHead;
    int index = 0;
    indexToNode.put(index, newHead);
    nodeToIndex.put(head, index++);
    while (temp != null) {
      final Node newNode = new Node(temp.val);
      newTemp.next = newNode;
      indexToNode.put(index, newNode);
      nodeToIndex.put(temp, index++);
      temp = temp.next;
      newTemp = newTemp.next;
    }
    temp = head;
    newTemp = newHead;
    while (temp != null) {
      final Node random = indexToNode.get(nodeToIndex.get(temp.random));
      newTemp.random = random;
      temp = temp.next;
      newTemp = newTemp.next;
    }
    return newHead;
  }
}
