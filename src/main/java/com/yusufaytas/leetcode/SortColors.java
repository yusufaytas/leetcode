package com.yusufaytas.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color
are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Follow up:

    A rather straight forward solution is a two-pass algorithm using counting sort.
    First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array
    with total number of 0's, then 1's and followed by 2's.
    Could you come up with a one-pass algorithm using only constant space?

 */
public class SortColors
{
    public void sortColors(int[] nums)
    {
        int whiteIndex = 0, blueIndex = 0;
        for (int i = 0; i < nums.length; i++)
        {
            int current = nums[i];
            if (current == 0 && i >= blueIndex)
            {
                nums[i] = 2;
                nums[blueIndex++] = 1;
                nums[whiteIndex++] = 0;
            }
            else if (current == 0 && i >= whiteIndex)
            {
                nums[whiteIndex++] = 0;
                nums[i] = 1;
            }
            else if (current == 1 && i >= blueIndex)
            {
                nums[i] = 2;
                nums[blueIndex++] = 1;
            }
        }
    }

    public static void main(String[] args)
    {
        final int[] nums = {1};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.stream(nums).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(",")));
    }

}
