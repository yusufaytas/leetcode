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
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.



Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the
kth smallest frequently? How would you optimize the kthSmallest routine?

Constraints:

    The number of elements of the BST is between 1 to 10^4.
    You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 */
public class KthSmallestElementInBST {

  public int kthSmallest(final TreeNode root, int k) {
    if (root == null) {
      return -1;
    }
    final List<Integer> numbers = new ArrayList<>();
    inOrderTraversal(root, numbers);
    return numbers.get(k - 1);
  }

  private void inOrderTraversal(final TreeNode root, final List<Integer> numbers) {
    if (root != null) {
      inOrderTraversal(root.left, numbers);
      numbers.add(root.val);
      inOrderTraversal(root.right, numbers);
    }
  }
}
