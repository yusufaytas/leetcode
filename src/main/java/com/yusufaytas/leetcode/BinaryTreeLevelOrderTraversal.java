package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

  public List<List<Integer>> levelOrder(final TreeNode root) {
    final List<List<Integer>> levels = new ArrayList<>();
    levelOrder(root, 0, levels);
    return levels;
  }

  public void levelOrder(final TreeNode root, final int current, final List<List<Integer>> levels) {
    if (root == null) {
      return;
    }
    if (levels.size() == current) {
      levels.add(new ArrayList<>());
    }
    levels.get(current).add(root.val);
    levelOrder(root.left, current + 1, levels);
    levelOrder(root.right, current + 1, levels);
  }
}
