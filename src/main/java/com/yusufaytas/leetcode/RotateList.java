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

/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL

Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList {

  public static void main(String[] args) {
    final ListNode head = new ListNode(0);
    head.next = new ListNode(1);
    head.next.next = new ListNode(2);
    System.out.println(new RotateList().rotateRight(head, 4));
  }

  public ListNode rotateRight(final ListNode head, int k) {
    if (head == null) {
      return null;
    }
    ListNode temp = head;
    int size = 1;
    while (temp.next != null) {
      temp = temp.next;
      size++;
    }
    k = k % size;
    final ListNode tail = temp;
    for (int i = 0; i < k; i++) {
      int prevValue = head.val;
      head.val = tail.val;
      temp = head.next;
      while (temp != null) {
        final int newPrevValue = temp.val;
        temp.val = prevValue;
        prevValue = newPrevValue;
        temp = temp.next;
      }
    }
    return head;
  }
}
