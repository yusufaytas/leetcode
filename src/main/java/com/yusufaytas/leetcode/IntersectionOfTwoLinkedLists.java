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

import java.util.HashSet;
import java.util.Set;

/*
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

begin to intersect at node c1.



Example 1:

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5].
There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 */
public class IntersectionOfTwoLinkedLists {

  public ListNode getIntersectionNode(final ListNode headA, final ListNode headB) {
    final Set<ListNode> nodes = new HashSet<>();
    ListNode current = headA;
    while (current != null) {
      nodes.add(current);
      current = current.next;
    }
    current = headB;
    while (current != null && !nodes.contains(current)) {
      current = current.next;
    }
    return current;
  }

}
