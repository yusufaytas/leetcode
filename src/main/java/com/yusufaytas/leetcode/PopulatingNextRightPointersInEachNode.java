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
