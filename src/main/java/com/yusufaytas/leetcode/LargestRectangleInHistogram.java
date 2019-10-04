package com.yusufaytas.leetcode;

public class LargestRectangleInHistogram
{
    public int largestRectangleArea(final int[] heights)
    {
        int max = 0;
        for (int i = 0; i < heights.length; i++)
        {
            int maxPossibleHeight = heights[i];
            max = Math.max(max, maxPossibleHeight);
            for (int j = i + 1; j < heights.length; j++)
            {
                if (maxPossibleHeight > heights[j])
                {
                    maxPossibleHeight = heights[j];
                }
                max = Math.max(max, maxPossibleHeight * (j - i + 1));
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        int nums[] = {2, 1, 5, 6, 2, 3};
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(nums));
    }
}
