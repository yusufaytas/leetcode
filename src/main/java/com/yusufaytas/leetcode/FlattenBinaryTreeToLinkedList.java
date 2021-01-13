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
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:
 */
public class FlattenBinaryTreeToLinkedList {

  public static void main(String[] args) {
    final TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(5);
    root.right.right = new TreeNode(5);
    new FlattenBinaryTreeToLinkedList().flatten(root);
    System.out.println(root);
  }

  public void flatten(final TreeNode root) {
    if (root == null) {
      return;
    }
    flatten(root.left);
    flatten(root.right);
    TreeNode leftEnd = root.left;
    if (root.left == null) {
      return;
    }
    while (leftEnd.right != null) {
      leftEnd = leftEnd.right;
    }
    leftEnd.right = root.right;
    root.right = root.left;
    root.left = null;
  }
}
