package com.yusufaytas.leetcode;

import static com.yusufaytas.leetcode.Utils.printArray;

public class RemoveElement
{
    public int removeElement(int[] nums, int val)
    {
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--)
        {
            if (nums[i] == val)
            {
                count++;
                final int temp = nums[nums.length - count];
                nums[nums.length - count] = nums[i];
                nums[i] = temp;
            }
        }
        return nums.length - count;
    }

    public static void main(String[] args)
    {
        final int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(new RemoveElement().removeElement(nums, 2));
        printArray(nums);
    }
}
