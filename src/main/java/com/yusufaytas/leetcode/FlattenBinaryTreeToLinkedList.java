package com.yusufaytas.leetcode;

/*
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:
 */
public class FlattenBinaryTreeToLinkedList
{
    public void flatten(final TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode leftEnd = root.left;
        if (root.left == null)
        {
            return;
        }
        while (leftEnd.right != null)
        {
            leftEnd = leftEnd.right;
        }
        leftEnd.right = root.right;
        root.right = root.left;
        root.left = null;
    }

    public static void main(String[] args)
    {
        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        new FlattenBinaryTreeToLinkedList().flatten(root);
        System.out.println(root);
    }
}
