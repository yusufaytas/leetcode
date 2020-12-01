package com.yusufaytas.leetcode;

public class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }

  @Override
  public String toString() {
    String values = "" + val;
    ListNode current = next;
    while (current != null) {
      values += ",";
      values += current.val;
      current = current.next;
    }
    return values;
  }
}
