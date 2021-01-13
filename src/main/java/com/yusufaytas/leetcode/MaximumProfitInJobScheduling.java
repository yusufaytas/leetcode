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

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
We have n jobs, where every job is scheduled to be done from
startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime , endTime and profit arrays, you need to output the maximum profit
you can take such that there are no 2 jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.

Example 1:

Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job.
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.

 */
public class MaximumProfitInJobScheduling {

  public int jobScheduling(final int[] startTime, final int[] endTime, final int[] profit) {
    if (startTime == null || startTime.length == 0
        || endTime == null || endTime.length == 0
        || profit == null || profit.length == 0) {
      return -1;
    }
    final Map<Integer, List<Integer>> groupedIndexes = IntStream.range(0, startTime.length)
        .boxed()
        .collect(Collectors.groupingBy(i -> startTime[i]));
    final int[] maxProfit = new int[IntStream.of(endTime).max().getAsInt() + 1];
    for (int i = maxProfit.length - 1; i >= 0; i--) {
      maxProfit[i] = i + 1 < maxProfit.length ? maxProfit[i + 1] : 0;
      if (groupedIndexes.containsKey(i)) {
        for (final int index : groupedIndexes.get(i)) {
          maxProfit[i] = Math.max(maxProfit[i], profit[index] + maxProfit[endTime[index]]);
        }
      }
    }
    return maxProfit[1];
  }

  public static void main(String[] args) {
    int[] startTime = {1, 2, 3, 4, 6};
    int[] endTime = {3, 5, 10, 6, 9};
    int[] profit = {20, 20, 100, 70, 60};
    System.out
        .println(new MaximumProfitInJobScheduling().jobScheduling(startTime, endTime, profit));
  }
}
