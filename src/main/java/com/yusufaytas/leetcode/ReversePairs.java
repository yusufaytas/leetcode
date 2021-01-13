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

/*
{{REVISIT}}

Check out merge sort implementation
Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
You need to return the number of important reverse pairs in the given array.
Example1:
Input: [1,3,2,3,1]
Output: 2

Example2:
Input: [2,4,3,5,1]
Output: 3

Note:
The length of the given array will not exceed 50,000.
All the numbers in the input array are in the range of 32-bit integer.
 */
public class ReversePairs {

  public int reversePairs(int[] nums) {

    if (nums == null || nums.length == 0) {
      return 0;
    }

    int n = nums.length;

    TreeNode root = new TreeNode(nums[0]);
    int count = 0;
    for (int i = 1; i < nums.length; i++) {
      count += search(root, (long) nums[i] * 2);
      root = insert(root, (long) nums[i]);
    }

    return count;

  }

  private int search(TreeNode root, long key) {

    if (root == null) {
      return 0;
    }

    if (key < root.value) {       // key < root.value:  go left
      return root.rightCount + search(root.left, key);
    } else {                    // key >= root.value: go right
      return search(root.right, key);
    }
  }

  private TreeNode insert(TreeNode root, long key) {

    if (root == null) {
      return new TreeNode(key);
    }

    if (key < root.value) {   // key < root.value:  go left
      root.left = insert(root.left, key);
    } else if (key == root.value) {
      root.rightCount++;
      return root;
    } else {
      root.rightCount++;
      root.right = insert(root.right, key);
    }

    root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;

    int balance = getBalance(root);

    // case 1 left left
    if (balance > 1 && getHeight(root.left.left) > getHeight(root.left.right)) {
      return rightRotate(root);
    }

    // case 2 left right
    if (balance > 1 && getHeight(root.left.left) < getHeight(root.left.right)) {
      root.left = leftRotate(root.left);
      return rightRotate(root);
    }

    // case 3 right right
    if (balance < -1 && getHeight(root.right.left) < getHeight(root.right.right)) {
      return leftRotate(root);
    }

    // case 4 right left
    if (balance < -1 && getHeight(root.right.left) > getHeight(root.right.right)) {
      root.right = rightRotate(root.right);
      return leftRotate(root);
    }

    return root;
  }

  private TreeNode leftRotate(TreeNode root) {

    // setp 1: take care of nodes
    TreeNode newRoot = root.right;
    TreeNode b = newRoot.left;

    newRoot.left = root;
    root.right = b;

    // step 2: take care of height
    root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;

    // step 3: take care of rightCount
    root.rightCount -= getRightCount(newRoot);

    return newRoot;
  }

  private TreeNode rightRotate(TreeNode root) {

    // setp 1: take care of nodes
    TreeNode newRoot = root.left;
    TreeNode b = newRoot.right;

    newRoot.right = root;
    root.left = b;

    // step 2: take care of height
    root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;

    // step 3: take care of rightCount
    newRoot.rightCount += getRightCount(root);

    return newRoot;
  }


  private int getHeight(TreeNode node) {
    return node == null ? 0 : node.height;
  }

  private int getBalance(TreeNode node) {
    return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
  }

  private int getRightCount(TreeNode node) {
    return node == null ? 0 : node.rightCount;
  }

  class TreeNode {

    long value;
    int rightCount;
    int height;
    TreeNode left;
    TreeNode right;

    public TreeNode(long value) {
      this.value = value;
      height = 1;
      rightCount = 1;
    }
  }
}
