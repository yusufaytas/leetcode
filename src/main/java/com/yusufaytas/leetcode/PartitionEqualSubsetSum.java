package com.yusufaytas.leetcode;

import java.util.Arrays;

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
        final int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1 || nums.length < 2)
        {
            return false;
        }
        final int halfSum = sum / 2;
        final boolean[][] sums = new boolean[nums.length + 1][halfSum + 1];
        for (int i = 0; i <= nums.length; i++)
        {
            sums[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++)
        {
            for (int j = 1; j <= halfSum; j++)
            {
                if (j - nums[i - 1] >= 0)
                {
                    sums[i][j] = sums[i - 1][j] || sums[i - 1][j - nums[i - 1]];
                }
            }
        }

        return sums[nums.length][halfSum];
    }

    public static void main(String[] args)
    {
        final int[] nums = {2, 2, 3, 5, 10};
        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));
    }
}
