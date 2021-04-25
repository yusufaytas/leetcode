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
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

Follow up:

    Could you solve the problem in O(1) extra memory space?
    You may not alter the values in the list's nodes, only nodes itself may be changed.

 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(final ListNode head, final int k) {
        int count = 0;
        ListNode current = head, start = head;
        final int[] buffer = new int[k];
        while (current != null) {
            buffer[count % k] = current.val;
            current = current.next;
            count++;
            if (count % k == 0) {
                ListNode kCurrent = start;
                for (int i = k - 1; i >= 0; i--) {
                    kCurrent.val = buffer[i];
                    kCurrent = kCurrent.next;
                }
                start = current;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        final ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(new ReverseNodesInKGroup().reverseKGroup(node, 2));
    }
}
