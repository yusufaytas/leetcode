package com.yusufaytas.leetcode;

public class ConvertSortedArrayToBinarySearchTree {

  public TreeNode sortedArrayToBST(final int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    return traverse(nums, 0, nums.length - 1);
  }

  public TreeNode traverse(final int[] nums, final int start, final int end) {
    if (end < start) {
      return null;
    }
    if (end == start) {
      return new TreeNode(nums[start]);
    }
    final int mid = (start + end + 1) / 2;
    final TreeNode node = new TreeNode(nums[mid]);
    node.left = traverse(nums, start, mid - 1);
    node.right = traverse(nums, mid + 1, end);
    return node;
  }

  public static void main(String[] args) {
    final int[] nums = {-10, 0, 0, 1};
    final TreeNode node = new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(nums);
    System.out.println(node.toString());
  }
}
