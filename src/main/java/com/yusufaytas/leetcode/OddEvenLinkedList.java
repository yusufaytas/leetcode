package com.yusufaytas.leetcode;

/*
Given a singly linked list, group all odd nodes together followed by the even nodes.
Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL

Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL

 */
    public class OddEvenLinkedList
{
    public ListNode oddEvenList(final ListNode head)
    {
        int index = 3;
        ListNode odd = head, even = odd != null && odd.next != null ? odd.next : null,
                evenHead = even, temp = even != null ? even.next : null;
        while (temp != null)
        {
            if (index++ % 2 == 0)
            {
                even.next = temp;
                even = even.next;
            }
            else
            {
                odd.next = temp;
                odd = odd.next;
            }
            temp = temp.next;
        }
        even.next = null;
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args)
    {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        System.out.println(new OddEvenLinkedList().oddEvenList(listNode));
    }
}
