package com.yusufaytas.leetcode;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions
as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

Example:

Input: [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]

 */
public class BestTimeBuySellStockCooldown
{
    public int maxProfit(final int[] prices)
    {
        if (prices == null || prices.length == 0)
        {
            return 0;
        }
        final int[][] profits = new int[prices.length][prices.length];
        maxProfit(prices, profits, 0, prices.length - 1);
        return profits[0][profits.length - 1];
    }

    private void maxProfit(final int[] prices, final int[][] profits, int start, int end)
    {
        if (start >= end)
        {
            return;
        }
        if (profits[start][end] != 0)
        {
            return;
        }
        int localMin = Integer.MAX_VALUE, localMax = Integer.MIN_VALUE, max = 0;
        for (int i = start; i <= end; i++)
        {
            if (prices[i] < localMin)
            {
                localMin = prices[i];
                localMax = prices[i];
            }
            if (prices[i] > localMax)
            {
                localMax = prices[i];
            }
            max = Math.max(localMax - localMin, max);
        }
        for (int i = start; i < end - 1; i++)
        {
            maxProfit(prices, profits, start, i + 1);
            maxProfit(prices, profits, i + 3, end);
            if (i + 3 <= end)
            {
                max = Math.max(profits[start][i + 1] + profits[i + 3][end], max);
            }
        }
        profits[start][end] = max;
    }

    public static void main(String[] args)
    {
        int[] prices = {1, 2, 3, 0, 2, 5, 21, 1, 1, 1, 32, 32, 3, 2, 3, 23};
        System.out.println(new BestTimeBuySellStockCooldown().maxProfit(prices));
    }
}
