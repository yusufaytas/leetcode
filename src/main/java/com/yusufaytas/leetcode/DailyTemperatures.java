package com.yusufaytas.leetcode;

/*
Given a list of daily temperatures T, return a list such that, for each day in the input,
tells you how many days you would have to wait until a warmer temperature.
If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73],
your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000].
Each temperature will be an integer in the range [30, 100].
 */
public class DailyTemperatures
{
    public int[] dailyTemperatures(final int[] temperatures)
    {
        final int[] daysToWarmerDays = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++)
        {
            for (int j = i + 1; j < temperatures.length; j++)
            {
                if (temperatures[j] > temperatures[i])
                {
                    daysToWarmerDays[i] = j - i;
                    break;
                }
            }
        }
        return daysToWarmerDays;
    }
}
