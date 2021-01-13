package com.yusufaytas.leetcode;

/*
Your are given an array of integers prices, for which the i-th element is the price of
a given stock on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction
fee for each transaction. You may not buy more than 1 share of a stock at a time
(ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:

Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

  public int maxProfit(final int[] prices, final int fee) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    final int[][] maxProfit = new int[prices.length][2];
    maxProfit[0][0] = 0;
    maxProfit[0][1] = -prices[0] - fee;
    for (int i = 1; i < prices.length; i++) {
      maxProfit[i][0] = Math.max(maxProfit[i - 1][1] + prices[i], maxProfit[i - 1][0]);
      maxProfit[i][1] = Math.max(maxProfit[i - 1][0] - prices[i] - fee, maxProfit[i - 1][1]);
    }
    return Math.max(maxProfit[maxProfit.length - 1][0], maxProfit[maxProfit.length - 1][1]);
  }

  public static void main(String[] args) {
    final int[] prices = {1, 3, 7, 5, 10, 3};
    final int fee = 3;
    System.out.println(new BestTimeToBuyAndSellStockWithTransactionFee().maxProfit(prices, fee));
  }
}
