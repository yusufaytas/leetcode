package com.yusufaytas.leetcode;

/*
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially
positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health
point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering
these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7
if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 */
public class DungeonGame {

  public int calculateMinimumHP(final int[][] dungeon) {
    if (dungeon == null || dungeon.length == 0) {
      return 0;
    }
    int min = computeMin(dungeon, 0, 0, 0, 0);
    return (min < 0 ? Math.abs(min) : 0) + 1;
  }

  public int computeMin(final int[][] dungeon, final int i, final int j,
      final int min, final int total) {
    if (i == dungeon.length - 1 && j == dungeon[0].length - 1) {
      return Math.min(min, total + dungeon[i][j]);
    }
    int maxMin = Integer.MIN_VALUE;
    if (i < dungeon.length - 1) {
      maxMin = Math.max(maxMin,
          computeMin(dungeon, i + 1, j, Math.min(total + dungeon[i][j], min),
              total + dungeon[i][j]));
    }
    if (j < dungeon[0].length - 1) {
      maxMin = Math.max(maxMin,
          computeMin(dungeon, i, j + 1, Math.min(total + dungeon[i][j], min),
              total + dungeon[i][j]));
    }
    return maxMin;
  }

  public static void main(String[] args) {
    final int[][] dungeon = {
        {0, 0}
    };
    System.out.println(new DungeonGame().calculateMinimumHP(dungeon));
  }
}
