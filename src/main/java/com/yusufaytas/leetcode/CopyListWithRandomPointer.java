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
