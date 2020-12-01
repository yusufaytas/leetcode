package com.yusufaytas.leetcode;

/*
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.



Follow up:

    You may only use constant extra space.
    Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.

 */
public class PopulatingNextRightPointersInEachNode {

  public static void main(String[] args) {
    final Node root = new Node(1);
    root.left = new Node(2);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right = new Node(3);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    new PopulatingNextRightPointersInEachNode().connect(root);
    System.out.println(root);
  }

  public Node connect(Node root) {
    connect(root, null);
    return root;
  }

  public void connect(Node root, Node right) {
    if (root == null) {
      return;
    }
    if (right != null) {
      root.next = right;
    }
    connect(root.left, root.right);
    connect(root.right, null);
    if (right != null) {
      connect(root.right, right.left);
    }
  }

  private static class Node {

    Node left, right, next;
    int val;

    public Node(int val) {
      this.val = val;
    }

    @Override
    public String toString() {
      return Integer.toString(val);
    }
  }
}
