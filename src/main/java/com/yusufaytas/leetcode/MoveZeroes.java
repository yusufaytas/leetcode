package com.yusufaytas.leetcode;

import static com.yusufaytas.leetcode.Utils.printArray;

/*
Given an array nums, write a function to move all 0's to the end of
it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.

 */
public class MoveZeroes
{
    public void moveZeroes(int[] nums)
    {
        int nonZeroIndex = -1;
        for (int i = 0; i < nums.length; i++)
        {
            if(nums[i] != 0)
            {
                int temp = nums[i];
                nums[i] = 0;
                nums[++nonZeroIndex] = temp;
            }
        }
    }

    public static void main(String [] args)
    {
        final int [] nums = {1};
        new MoveZeroes().moveZeroes(nums);
        printArray(nums);
    }
}
