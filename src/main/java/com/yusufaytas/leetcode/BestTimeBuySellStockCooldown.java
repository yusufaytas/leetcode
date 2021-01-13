/**
 * Copyright © 2021 Yusuf Aytas. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yusufaytas.leetcode;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions
as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

Example:

Input: [1,2,3,0,2,5,2,8]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]

 */
public class BestTimeBuySellStockCooldown {

  public static void main(String[] args) {
    int[] prices = {1, 2, 3, 0, 2};
    System.out.println(new BestTimeBuySellStockCooldown().maxProfit(prices));
  }

  public int maxProfit(final int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    final int[][] profits = new int[prices.length][3];
    return maxProfit(prices, profits, 0, 0);
  }

  //state=0 noStock, state=1 => hasStock, state=2 => cooldown
  public int maxProfit(final int[] prices, final int[][] profits,
      final int start, final int state) {
    if (start == prices.length) {
      return 0;
    }
    if (profits[start][state] != 0) {
      return profits[start][state];
    }
    int buyProfit = Integer.MIN_VALUE, sellProfit = Integer.MIN_VALUE, coolDown = Integer.MIN_VALUE;
    if (state == 0) {
      buyProfit = Math.max(maxProfit(prices, profits, start + 1, 1) - prices[start],
          maxProfit(prices, profits, start + 1, 0));

    } else if (state == 1) {
      sellProfit = Math.max(maxProfit(prices, profits, start + 1, 2) + prices[start],
          maxProfit(prices, profits, start + 1, 1));
    } else {
      coolDown = maxProfit(prices, profits, start + 1, 0);
    }
    profits[start][state] = Math.max(buyProfit, Math.max(sellProfit, coolDown));
    return profits[start][state];
  }
}
