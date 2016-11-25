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
public class RemoveNthNode
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode nth = head, temp = head;
        for (int i = 0; i < n; i++)
        {
            nth = nth.next;
        }
        while (nth != null && nth.next != null)
        {
            temp = temp.next;
            nth = nth.next;
        }
        if (temp.next == null)
        {
            return null;
        }
        if (nth == null)
        {
            head = temp.next;
        }
        else
        {
            temp.next = temp.next.next;
        }
        return head;
    }

}
