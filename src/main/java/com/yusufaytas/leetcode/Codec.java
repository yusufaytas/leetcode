package com.yusufaytas.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored
in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same
or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized
to a string and this string can be deserialized to the original tree structure.

Example:

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"

Clarification: The above format is the same as how LeetCode serializes a binary tree.
You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
//Serialize and Deserialize Binary Tree
public class Codec
{

    // Encodes a tree to a single string.
    public String serialize(final TreeNode root)
    {
        if (root == null)
        {
            return "";
        }
        Object nums[] = new Object[1];
        final Stack<TreeNode> nodeStack = new Stack<>();
        final Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(0);
        while (!nodeStack.isEmpty())
        {
            final TreeNode currentNode = nodeStack.pop();
            final int currentIndex = depthStack.pop();
            if (currentIndex >= nums.length)
            {
                nums = Arrays.copyOf(nums, 2 * (nums.length + 1) - 1);
            }
            nums[currentIndex] = currentNode.val;
            final int rightIndex = 2 * (currentIndex + 1);
            final int leftIndex = rightIndex - 1;
            if (currentNode.left != null)
            {
                nodeStack.push(currentNode.left);
                depthStack.push(leftIndex);
            }
            if (currentNode.right != null)
            {
                nodeStack.push(currentNode.right);
                depthStack.push(rightIndex);
            }
        }
        return Arrays.stream(nums).map(o -> o == null ? "" : o.toString())
                .collect(Collectors.joining(","));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(final String data)
    {
        if (data.isEmpty())
        {
            return null;
        }
        final List<TreeNode> nodes = Arrays
                .stream(data.split(","))
                .map(String::trim)
                .map(s -> s.isEmpty() ? null : new TreeNode(Integer.parseInt(s)))
                .collect(Collectors.toList());
        for (int i = 0; i < nodes.size(); i++)
        {
            final int rightIndex = 2 * (i + 1);
            final int leftIndex = rightIndex - 1;
            if (rightIndex < nodes.size() && nodes.get(rightIndex) != null)
            {
                nodes.get(i).right = nodes.get(rightIndex);
            }
            if (leftIndex < nodes.size() && nodes.get(leftIndex) != null)
            {
                nodes.get(i).left = nodes.get(leftIndex);
            }
        }
        return nodes.get(0);
    }

    public static void main(String[] args)
    {
        final Codec codec = new Codec();
        final TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(5);
        treeNode.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(10);
        System.out.println(codec.serialize(treeNode));
    }
}
