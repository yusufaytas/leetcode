package com.yusufaytas.leetcode;

import java.util.Arrays;

/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10, 9, 2, 5, 3, 7, 101, 18]

Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Note:

    There may be more than one LIS combination, it is only necessary for you to return the length.
    Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence
{
    public int lengthOfLIS(final int[] nums)
    {
        if(nums.length == 0)
        {
            return 0;
        }
        final int[] localMax = new int[nums.length];
        Arrays.fill(localMax, 1);
        for (int i = 1; i < nums.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (nums[i] > nums[j])
                {
                    localMax[i] = Math.max(localMax[i], localMax[j] + 1);
                }
            }
        }
        return Arrays.stream(localMax).max().getAsInt();
    }

    public static void main(String[] args)
    {
        final int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    }
}
