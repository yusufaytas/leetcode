package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,4]
Output: 3
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
        final List<Integer> list = new ArrayList<>();
        return lengthOfLIS(nums, 0, list);
    }

    public int lengthOfLIS(final int[] nums, final int index, final List<Integer> list)
    {
        if (index == nums.length)
        {
            return list.size();
        }
        if (list.isEmpty() || nums[index] > list.get(list.size() - 1))
        {
            list.add(nums[index]);
            return lengthOfLIS(nums, index + 1, list);
        }
        if (list.size() == 1)
        {
            list.remove(0);
            list.add(nums[index]);
            return lengthOfLIS(nums, index + 1, list);
        }
        final int newIndex = Math.abs(Collections.binarySearch(list, nums[index]));
        final List<Integer> newList = new ArrayList<>(newIndex);
        for (int i = 0; i < newIndex - 1; i++)
        {
            newList.add(list.get(i));
        }
        return Math.max(lengthOfLIS(nums, index + 1, list), lengthOfLIS(nums, index, newList));
    }

    public static void main(String[] args)
    {
        final int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    }
}
