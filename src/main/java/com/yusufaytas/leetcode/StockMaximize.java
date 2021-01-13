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

import java.util.Arrays;
import java.util.List;

public class StockMaximize {

  public int maxProfit(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }
    int max = 0, localMin = 0, localMax = 1;
    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i] < prices[localMin]) {
        localMin = i;
        localMax = i + 1; // restart
      }
      if (prices[i + 1] > prices[localMax]) {
        localMax = i + 1;
      }
      int currentMax = prices[localMax] - prices[localMin];
      if (currentMax > max) {
        max = currentMax;
      }
    }
    return max;
  }

  public int maxProfitMultipleTransaction(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }
    int total = 0, localMin = Integer.MAX_VALUE;
    for (int i = 1; i < prices.length; i++) {
      if (localMin > prices[i - 1]) {
        localMin = prices[i - 1];
      }
      if (prices[i - 1] >= prices[i]) {
        total += prices[i - 1] - localMin;
        localMin = Integer.MAX_VALUE;
      }
    }
    total += prices[prices.length - 1] - localMin > 0 ? prices[prices.length - 1] - localMin : 0;
    return total;
  }

  public int maxProfit(int[] prices, int fee) {
    if (prices.length < 2) {
      return 0;
    }
    int total = 0, localMin = Integer.MAX_VALUE, localMax = fee;
    for (int i = 1; i < prices.length; i++) {
      if (localMin > prices[i - 1]) {
        localMin = prices[i - 1];
      }
      if (prices[i] > localMax) {
        localMax = prices[i];
      }
      if (localMax > prices[i]) {
        total += localMax - localMin - fee > 0 ? localMax - localMin - fee : 0;
        localMin = Integer.MAX_VALUE;
        localMax = fee;
      }
    }
    return total;
  }

  //Allows buying as much as possible
  public long maximumProfit(final List<Integer> prices) {
    if (prices == null || prices.size() < 2) {
      return 0;
    }
    long total = 0;
    int localMax = prices.get(prices.size() - 1);
    for (int i = prices.size() - 2; i >= 0; i--) {
      if (localMax < prices.get(i)) {
        localMax = prices.get(i);
        continue;
      }
      total += localMax - prices.get(i);
    }
    return total;
  }

  public static void main(String[] args) {
    System.out.println(new StockMaximize().maximumProfit(Arrays.asList(1, 4, 9, 2, 11)));
  }
}
