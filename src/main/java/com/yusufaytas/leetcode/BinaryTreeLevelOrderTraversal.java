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
