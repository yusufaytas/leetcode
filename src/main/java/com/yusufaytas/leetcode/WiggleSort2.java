package com.yusufaytas.leetcode;


import java.util.Arrays;


import static com.yusufaytas.leetcode.Utils.printArray;

/*
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].

Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
TODO: revisit
 */
public class WiggleSort2
{
    public void wiggleSort(final int[] nums)
    {
        if (nums == null || nums.length < 2)
        {
            return;
        }
        final int[] copy = Arrays.copyOf(nums, nums.length);

        Arrays.sort(copy);

        int smallHalfEnd = (nums.length - 1) / 2;
        int bigHalfEnd = nums.length - 1;

        for (int i = 0; i < nums.length; i++)
        {
            if (i % 2 == 0)
            {
                nums[i] = copy[smallHalfEnd--];
            }
            else
            {
                nums[i] = copy[bigHalfEnd--];
            }
        }
    }

    public static void main(final String[] args)
    {
        final int[] nums = {2, 3, 1, 3, 1, 2};
        new WiggleSort2().wiggleSort(nums);
        printArray(nums);
    }
}
