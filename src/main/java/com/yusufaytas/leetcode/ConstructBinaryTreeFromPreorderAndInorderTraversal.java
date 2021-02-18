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
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

  public TreeNode buildTree(final int[] preorder, final int[] inorder) {
    if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0
        || inorder.length != preorder.length) {
      return null;
    }
    return buildTree(preorder, inorder, 0, inorder.length - 1, 0, inorder.length - 1);
  }

  public TreeNode buildTree(final int[] preorder, final int[] inorder,
      final int preStart, final int preEnd, final int inStart, final int inEnd) {
    if (preStart > preEnd) {
      return null;
    }
    if (preStart == preEnd) {
      return new TreeNode(preorder[preStart]);
    }
    final TreeNode node = new TreeNode(preorder[preStart]);
    int count = 0;
    for (int i = inStart; i <= inEnd; i++) {
      if (preorder[preStart] == inorder[i]) {
        break;
      }
      count++;
    }
    node.left = buildTree(preorder, inorder,
        preStart + 1, preStart + count,
        inStart, inStart + count);
    node.right = buildTree(preorder, inorder,
        preStart + count + 1, preEnd,
        inStart + count + 1, inEnd);
    return node;
  }

  public static void main(String[] args) {
    final int[] preorder = {5, 4, 3, 2, 1};
    final int[] inorder = {1, 2, 3, 4, 5};
    final TreeNode node = new ConstructBinaryTreeFromPreorderAndInorderTraversal()
        .buildTree(preorder, inorder);
    System.out.println(node);
  }
}
