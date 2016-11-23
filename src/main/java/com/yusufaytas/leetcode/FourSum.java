package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
{{REVISIT}}
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
public class FourSum
{
    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4)
        {
            return quadruplets;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1])//skipping duplicates, very important
            {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++)
            {
                if (j > i + 1 && nums[j] == nums[j - 1])
                {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++)
                {
                    if (k > j + 1 && nums[k] == nums[k - 1])
                    {
                        continue;
                    }
                    int l = k + 1;
                    while (l < nums.length && target > nums[i] + nums[j] + nums[k] + nums[l])
                    {
                        l++;
                    }
                    if (l < nums.length && nums[i] + nums[j] + nums[k] + nums[l] == target)
                    {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                    }
                }
            }
        }

        return quadruplets;
    }

}
