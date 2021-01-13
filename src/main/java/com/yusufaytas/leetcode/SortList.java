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

import static com.yusufaytas.leetcode.Utils.generateListNode;

/*
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4

Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
 */
public class SortList {

  public static void main(String[] args) {
    System.out.println(new SortList().sortList(generateListNode(5, 1, 4, 0, 7, 10, 11, 2)));
  }

  public ListNode sortList(final ListNode head) {
    ListNode current = head;
    while (current != null && current.next != null) {
      current = current.next;
    }
    return sortList(head, current);
  }

  public ListNode sortList(final ListNode head, final ListNode endNode) {
    if (head == null || head == endNode || head == endNode.next) {
      return head;
    }
    final int pivot = head.val;
    ListNode lessThanPivot = head, current = head.next;
    while (current != null && current != endNode.next) {
      if (current.val <= pivot) {
        int temp = lessThanPivot.next.val;
        lessThanPivot = lessThanPivot.next;
        lessThanPivot.val = current.val;
        current.val = temp;
      }
      current = current.next;
    }
    lessThanPivot.val = pivot;
    sortList(head.next, lessThanPivot);
    current = head;
    while (current != lessThanPivot && current.next != null) {
      current.val = current.next.val;
      current = current.next;
    }

    sortList(lessThanPivot.next, endNode);
    return head;
  }
}
