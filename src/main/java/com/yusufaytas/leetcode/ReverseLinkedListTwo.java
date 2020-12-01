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
