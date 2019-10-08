package com.yusufaytas.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

Note: Do not modify the linked list.



Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:

Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:

Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.

Follow-up:
Can you solve it without using extra space?
 */
public class LinkedListCycleTwo
{
    public ListNode detectCycle(final ListNode head)
    {
        final Set<ListNode> seen = new HashSet<>();
        ListNode current = head;
        while (current != null)
        {
            if (seen.contains(current))
            {
                return current;
            }
            seen.add(current);
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args)
    {
        final ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        final ListNode result = new LinkedListCycleTwo().detectCycle(head);
        System.out.println(result == null ? null : result.val);
    }
}
