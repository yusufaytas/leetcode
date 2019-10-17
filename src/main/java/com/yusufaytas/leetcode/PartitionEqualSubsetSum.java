package com.yusufaytas.leetcode;

/*
Given a non-empty array containing only positive integers, find if the array can be partitioned into
two subsets such that the sum of elements in both subsets is equal.

Note:
    Each of the array element will not exceed 100.
    The array size will not exceed 200.

Example 1:
Input: [1, 5, 11, 5]
Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: [1, 2, 3, 5]
Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class PartitionEqualSubsetSum
{
    public boolean canPartition(final int[] nums)
    {
        return canPartition(nums, 0, 0, 0);
    }

    public boolean canPartition(final int[] nums, int index, final int left, final int right)
    {
        if (index == nums.length)
        {
            return left == right;
        }
        final int current = nums[index++];
        return canPartition(nums, index, left + current, right) ||
                canPartition(nums, index, left, right + current);
    }

    public static void main(String[] args)
    {
        final int[] nums = {1, 2, 3, 5};
        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));
    }
}
