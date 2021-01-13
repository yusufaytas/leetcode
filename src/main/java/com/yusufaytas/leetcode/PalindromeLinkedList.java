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
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false

Example 2:

Input: 1->2->2->1
Output: true

Follow up:
Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {

  public static void main(String[] args) {
    System.out.println(new PalindromeLinkedList().isPalindrome(generateListNode(1, 2, 2, 1)));
  }

  public boolean isPalindrome(final ListNode head) {
    int size = 0, count = 0;
    ListNode current = head, midNode = head;
    while (current != null) {
      current = current.next;
      size++;
    }
    final int mid = ((size + 1) / 2 + 1);
    while (++count < mid) {
      midNode = midNode.next;
    }
    current = midNode;
    ListNode prev = null;
    while (current != null) {
      final ListNode temp = current;
      current = current.next;
      temp.next = prev;
      prev = temp;
    }
    ListNode start = head;
    while (prev != null) {
      if (start.val != prev.val) {
        return false;
      }
      prev = prev.next;
      start = start.next;
    }
    return true;
  }
}
