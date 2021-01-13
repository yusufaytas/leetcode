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

public class MergeTwoSortedLists {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(Integer.MIN_VALUE), temp = head;
    while (l1 != null && l2 != null) {
      if (l1.val > l2.val) {
        temp.next = new ListNode(l2.val);
        l2 = l2.next;
      } else {
        temp.next = new ListNode(l1.val);
        l1 = l1.next;
      }
      temp = temp.next;
    }

    while (l1 != null) {
      temp.next = new ListNode(l1.val);
      l1 = l1.next;
      temp = temp.next;
    }

    while (l2 != null) {
      temp.next = new ListNode(l2.val);
      l2 = l2.next;
      temp = temp.next;
    }

    return head.next;
  }
}
