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
public class PalindromeLinkedList
{
    public boolean isPalindrome(final ListNode head)
    {
        int size = 0, count = 0;
        ListNode current = head, midNode = head;
        while (current != null)
        {
            current = current.next;
            size++;
        }
        final int mid = ((size + 1) / 2 + 1);
        while (++count < mid)
        {
            midNode = midNode.next;
        }
        current = midNode;
        ListNode prev = null;
        while (current != null)
        {
            final ListNode temp = current;
            current = current.next;
            temp.next = prev;
            prev = temp;
        }
        ListNode start = head;
        while (prev != null)
        {
            if(start.val != prev.val)
            {
                return false;
            }
            prev = prev.next;
            start = start.next;
        }
        return true;
    }

    public static void main(String [] args)
    {
        System.out.println(new PalindromeLinkedList().isPalindrome(generateListNode(1,2,2,1)));
    }
}
