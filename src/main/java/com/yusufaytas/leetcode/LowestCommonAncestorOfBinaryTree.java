package com.yusufaytas.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]



Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.



Note:

    All of the nodes' values will be unique.
    p and q are different and both values will exist in the binary tree.


 */
public class LowestCommonAncestorOfBinaryTree
{
    public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q)
    {
        final Queue<TreeNode> pathForP = new ArrayDeque<>();
        final Queue<TreeNode> pathForQ = new ArrayDeque<>();
        if (findNode(pathForP, root, p) && findNode(pathForQ, root, q))
        {
            while (!pathForP.isEmpty())
            {
                final TreeNode nodeForP = pathForP.poll();
                for (TreeNode nodeForQ : pathForQ)
                {
                    if(nodeForP == nodeForQ)
                    {
                        return nodeForP;
                    }
                }
            }
        }

        return root;
    }

    private boolean findNode(final Queue<TreeNode> path, final TreeNode root, final TreeNode nodeToFind)
    {
        if (root == null)
        {
            return false;
        }
        if (root == nodeToFind)
        {
            path.add(root);
            return true;
        }
        if (findNode(path, root.left, nodeToFind) || findNode(path, root.right, nodeToFind))
        {
            path.add(root);
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        final TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        System.out.println(new LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root, root.left, root.left.right.right ));
    }
}
