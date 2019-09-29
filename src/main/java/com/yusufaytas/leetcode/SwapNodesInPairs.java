package com.yusufaytas.leetcode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapNodesInPairs
{
    public ListNode swapPairs(final ListNode head) {
        ListNode current = head;
        while(current != null)
        {
            ListNode next = current;
            if(next.next != null)
            {
                ListNode nextNext = next.next;
                current = nextNext.next;
                int nextNextVal = nextNext.val;
                nextNext.val = next.val;
                next.val = nextNextVal;
            }
            else{
                return head;
            }
        }
        return head;
    }
}
