package com.yusufaytas.leetcode;

public class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x)
    {
        val = x;
    }

    @Override
    public String toString()
    {
        return Integer.toString(val);
    }
}