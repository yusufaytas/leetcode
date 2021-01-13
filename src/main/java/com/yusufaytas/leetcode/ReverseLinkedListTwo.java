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
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListTwo {

  public ListNode reverseBetween(final ListNode head, final int m, final int n) {
    ListNode beforeMNode = null, mNode = null, mNodeCurrent = null, current = head;
    int count = 0;
    while (current != null) {
      count++;
      final ListNode past = current;
      current = current.next;
      if (count == m - 1) {
        beforeMNode = past;
      }
      if (count == m) {
        mNode = past;
        mNodeCurrent = mNode;
        mNode.next = null;
      }
      if (count > m) {
        past.next = mNodeCurrent;
        mNodeCurrent = past;
      }
      if (count == n) {
        mNode.next = current;
        break;
      }
    }
    if (beforeMNode != null) {
      beforeMNode.next = mNodeCurrent;
      return head;
    }
    return mNodeCurrent;
  }

}
