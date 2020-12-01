package com.yusufaytas.leetcode;

/*
Given an integer array nums, find the contiguous subarray
(containing at least one number) which has the largest sum and return its sum.

Follow up: If you have figured out the O(n) solution,
try coding another solution using the divide and conquer approach, which is more subtle.

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray
{
    public int maxSubArray(final int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }
        int max = nums[0], localMax = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] + localMax < nums[i])
            {
                localMax = nums[i];
            }
            else if (nums[i] + localMax < 0)
            {
                localMax = nums[i];
            }
            else
            {
                localMax = nums[i] + localMax;
            }
            if (localMax > max)
            {
                max = localMax;
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        final int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }
}

