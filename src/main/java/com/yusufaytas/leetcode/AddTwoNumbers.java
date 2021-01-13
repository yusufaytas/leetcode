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
You are given two linked lists representing two non-negative numbers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

PS: Size of list can be different than eacher other3
 */
public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int residual = 0;
    ListNode sum = null, tempSum = null;
    while (l1 != null || l2 != null || residual != 0) {
      int partialSum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + residual;
      ListNode newSum = new ListNode(partialSum % 10);
      residual = partialSum / 10;
      if (sum == null) {
        sum = newSum;
        tempSum = sum;
      } else {
        tempSum.next = newSum;
        tempSum = tempSum.next;
      }
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    return sum;
  }

}
