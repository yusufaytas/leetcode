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
Given a linked list, remove the nth node from the end of list and return its head.

For example,

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */
public class RemoveNthNode {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode nth = head, temp = head;
    for (int i = 0; i < n; i++) {
      nth = nth.next;
    }
    while (nth != null && nth.next != null) {
      temp = temp.next;
      nth = nth.next;
    }
    if (temp.next == null) {
      return null;
    }
    if (nth == null) {
      head = temp.next;
    } else {
      temp.next = temp.next.next;
    }
    return head;
  }

}
