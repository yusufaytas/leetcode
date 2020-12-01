package com.yusufaytas.leetcode;

/*
Invert a binary tree.
Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9

Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 */
public class InvertBinaryTree {

  public TreeNode invertTree(final TreeNode root) {
    if (root != null) {
      final TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;
      invertTree(root.left);
      invertTree(root.right);
    }
    return root;
  }
}
