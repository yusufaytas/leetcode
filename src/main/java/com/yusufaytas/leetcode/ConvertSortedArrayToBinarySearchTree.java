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
