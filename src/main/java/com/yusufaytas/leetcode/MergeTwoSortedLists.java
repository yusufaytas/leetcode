package com.yusufaytas.leetcode;

public class MergeTwoSortedLists
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode head = new ListNode(Integer.MIN_VALUE), temp = head;
        while (l1 != null && l2 != null)
        {
            if (l1.val > l2.val)
            {
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            else
            {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            temp = temp.next;
        }

        while (l1 != null)
        {
            temp.next = new ListNode(l1.val);
            l1 = l1.next;
            temp = temp.next;
        }

        while (l2 != null)
        {
            temp.next = new ListNode(l2.val);
            l2 = l2.next;
            temp = temp.next;
        }

        return head.next;
    }
}
