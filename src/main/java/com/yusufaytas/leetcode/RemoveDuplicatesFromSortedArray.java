package com.yusufaytas.leetcode;

/*
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the returned length.
 */
public class RemoveDuplicatesFromSortedArray
{
    public int removeDuplicates(final int[] nums) {
        if(nums.length == 0)
        {
            return 0;
        }
        int count = 1, current = nums[0];
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i] != current)
            {
                current = nums[i];
                nums[count] = current;
                count++;
            }
        }
        return count;
    }
}
