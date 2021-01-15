/**
 * Copyright © 2021 Yusuf Aytas. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1

Return:

[
   [5,4,11,2],
   [5,8,4,5]
]


 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class PathSum2 {

  public List<List<Integer>> pathSum(final TreeNode root, final int sum) {
    final List<List<Integer>> paths = new ArrayList<>();
    final List<Integer> path = new ArrayList<>();
    pathSum(paths, path, root, sum);
    return paths;
  }

  public void pathSum(final List<List<Integer>> paths, final List<Integer> path,
      final TreeNode root, final int sum) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      if (sum - root.val == 0) {
        final List<Integer> sumPath = new ArrayList<>(path);
        sumPath.add(root.val);
        paths.add(sumPath);
      }
      return;
    }
    path.add(root.val);
    pathSum(paths, path, root.left, sum - root.val);
    pathSum(paths, path, root.right, sum - root.val);
    path.remove(path.size() - 1);
  }
}
