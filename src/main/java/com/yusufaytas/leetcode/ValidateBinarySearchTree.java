package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true

Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree
{
    public boolean isValidBST(final TreeNode root)
    {
        final List<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values);
        for (int i = 1; i < values.size(); i++)
        {
            if(values.get(i-1) >=    values.get(i))
            {
                return false;
            }
        }
        return true;
    }

    public void inOrderTraversal(final TreeNode root, final List<Integer> nodes)
    {
        if(root != null)
        {
            inOrderTraversal(root.left, nodes);
            nodes.add(root.val);
            inOrderTraversal(root.right, nodes) ;
        }
    }

    public static void main(final String[] args)
    {
        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        System.out.println(new ValidateBinarySearchTree().isValidBST(root));
    }
}
