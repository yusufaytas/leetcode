package com.yusufaytas.leetcode;

/*
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:

    Return true if there exists i, j, k
    such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.

Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

Example 1:

Input: [1,2,3,4,5]
Output: true

Example 2:

Input: [5,4,3,2,1]
Output: false

 */
public class IncreasingTripletSubsequence
{
    public boolean increasingTriplet(final int[] nums)
    {
        if (nums == null || nums.length < 3)
        {
            return false;
        }
        int minIndex = nums[0] > nums[1] ? 1 : 0, midIndex = nums[0] > nums[1] ? 2 : 1, newMinIndex = -1;
        for (int i = midIndex + 1; i < nums.length; i++)
        {
            if (nums[i] > nums[midIndex] && nums[midIndex] > nums[minIndex] && midIndex > minIndex)
            {
                return true;
            }
            else if (nums[i] < nums[midIndex] && nums[i] > nums[minIndex])
            {
                midIndex = i;
            }
            else if (nums[i] > nums[midIndex] && nums[minIndex] == nums[midIndex])
            {
                midIndex = i;
            }
            else if (newMinIndex != -1 && nums[i] > nums[newMinIndex])
            {
                midIndex = i;
                minIndex = newMinIndex;
                newMinIndex = -1;
            }
            else if (nums[i] < nums[minIndex])
            {
                newMinIndex = i;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        final int[] nums = {1, 2, -10, -8, -7};
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(nums));
    }
}
