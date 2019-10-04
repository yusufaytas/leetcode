package com.yusufaytas.leetcode;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
[4,5,6,7,0,1,2][4,5,6,7,0,1,2]
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

 */
public class SearchInRotatedSortedArray
{
    public int search(final int[] nums, final int target)
    {
        return search(nums, 0, nums.length * 2 - 1, target);
    }

    private int search(final int[] nums, final int start, final int end, final int target)
    {
        if (start > end || start == end && nums[start % nums.length] != target)
        {
            return -1;
        }
        final int mid = (end + start - 1) / 2;
        final int midToUse = mid % nums.length;
        final int startToUse = start % nums.length;
        final int endToUse = end % nums.length;
        if (nums[startToUse] == target)
        {
            return startToUse;
        }
        if (nums[endToUse] == target)
        {
            return endToUse;
        }
        if (nums[midToUse] == target)
        {
            return midToUse;
        }
        else if (nums[midToUse] > target)
        {
            if (nums[midToUse] > nums[endToUse] && nums[endToUse] > target)
            {
                return search(nums, mid + 1, end, target);
            }
            return search(nums, start, mid - 1, target);
        }
        if (nums[midToUse] < nums[startToUse] && nums[startToUse] < target)
        {
            return search(nums, start, mid - 1, target);
        }
        return search(nums, mid + 1, end, target);
    }

    public static void main(String[] args)
    {
        final int target = 2;
        final int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println(new SearchInRotatedSortedArray().search(nums, target));
    }
}
