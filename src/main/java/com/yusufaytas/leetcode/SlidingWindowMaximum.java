package com.yusufaytas.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]
Explanation:

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Note:
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
 */
public class SlidingWindowMaximum
{
    public int[] maxSlidingWindow(final int[] nums, final int k)
    {
        if (nums.length < k || k == 0)
        {
            return new int[]{};
        }
        final Queue<Integer> slidingWindow = new PriorityQueue<>(Comparator.reverseOrder());
        final int[] maxForWindow = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++)
        {
            slidingWindow.add(nums[i]);
        }
        for (int i = 0; i < nums.length - k; i++)
        {
            maxForWindow[i] = slidingWindow.peek();
            slidingWindow.remove(nums[i]);
            slidingWindow.add(nums[i + k]);
        }
        maxForWindow[nums.length - k] = slidingWindow.peek();
        return maxForWindow;
    }

    public static void main(String[] args)
    {
        final int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        final int k = 3;
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(nums, k)));
    }
}
