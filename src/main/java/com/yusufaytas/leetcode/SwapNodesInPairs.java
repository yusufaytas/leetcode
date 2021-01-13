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

/**
 * Given a linked list, swap every two adjacent nodes and return its head. You may not modify the
 * values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
public class SwapNodesInPairs {

  public ListNode swapPairs(final ListNode head) {
    ListNode current = head;
    while (current != null) {
      ListNode next = current;
      if (next.next != null) {
        ListNode nextNext = next.next;
        current = nextNext.next;
        int nextNextVal = nextNext.val;
        nextNext.val = next.val;
        next.val = nextNextVal;
      } else {
        return head;
      }
    }
    return head;
  }
}
