package com.yusufaytas.leetcode;

/*
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from
some starting node to any node in the tree along the parent-child connections.
The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */
public class BinaryTreeMaximumPathSum
{
    private static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSum(root, max);
        return max[0];
    }

    public int maxPathSum(TreeNode node, int[] max)
    {
        if (node == null)
        {
            return 0;
        }
        int leftSum = maxPathSum(node.left, max);
        int rightSum = maxPathSum(node.right, max);

        int returnVal = Math.max(node.val, Math.max(leftSum + node.val, rightSum + node.val));
        int sum = Math.max(returnVal, node.val + leftSum + rightSum);
        if (sum > max[0])
        {
            max[0] = sum;
        }
        return returnVal;
    }

    public static void main(String[] args)
    {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(t1));
    }
}
