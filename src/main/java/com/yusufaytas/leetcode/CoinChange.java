package com.yusufaytas.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

Note:
You may assume that you have an infinite number of each kind of coin.

 */
public class CoinChange {

  public static void main(final String[] args) {
    int amount = 6249;
    int coins[] = {186, 419, 83, 408};

    System.out.println(new CoinChange().coinChange(coins, amount));
  }

  public int coinChange(final int[] coins, final int amount) {
    final Set<Integer> coinSet = new TreeSet<>(Comparator.reverseOrder());
    final Map<Integer, Integer> visited = new HashMap<>();
    for (int i = 0; i < coins.length; i++) {
      coinSet.add(coins[i]);
    }
    return coinChange(coinSet, visited, amount);
  }

  public int coinChange(final Set<Integer> coins, final Map<Integer, Integer> visited,
      final int amount) {
    if (visited.containsKey(amount)) {
      return visited.get(amount);
    }
    if (amount == 0) {
      return 0;
    }
    if (coins.contains(amount)) {
      return 1;
    }
    int min = Integer.MAX_VALUE;
    boolean hasResult = false;
    for (final int coin : coins) {
      final int remaining = amount - coin;
      if (remaining < 0) {
        continue;
      }
      final int result = coinChange(coins, visited, remaining);
      if (result == -1) {
        visited.put(remaining, -1);
        continue;
      }
      hasResult = true;
      min = Math.min(min, result);
    }
    if (hasResult) {
      visited.put(amount, min + 1);
      return min + 1;
    }
    return -1;
  }
}
