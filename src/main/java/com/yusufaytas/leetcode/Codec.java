package com.yusufaytas.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
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
public class Codec {

  public static void main(String[] args) {
    final Codec codec = new Codec();
    final TreeNode treeNode = new TreeNode(1);
    treeNode.right = new TreeNode(3);
    treeNode.right.right = new TreeNode(5);
    treeNode.left = new TreeNode(2);
    treeNode.left.right = new TreeNode(10);
    System.out.println(codec.serialize(treeNode));
    System.out.println(codec.serialize(codec.deserialize(codec.serialize(treeNode))));
  }

  // Encodes a tree to a single string.
  public String serialize(final TreeNode root) {
    if (root == null) {
      return ",";
    }
    return root.val + "," + serialize(root.left) + serialize(root.right);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(final String data) {
    if (data.isEmpty()) {
      return null;
    }
    final Queue<String> nodes = Arrays
        .stream(data.split(","))
        .map(String::trim)
        .collect(Collectors.toCollection(ArrayDeque::new));
    return constructTree(nodes);
  }

  private TreeNode constructTree(final Queue<String> nodes) {
    final String val = nodes.poll();
    if (val == null || val.isEmpty()) {
      return null;
    }
    final TreeNode treeNode = new TreeNode(Integer.parseInt(val));
    treeNode.left = constructTree(nodes);
    treeNode.right = constructTree(nodes);
    return treeNode;
  }
}
