package com.yusufaytas.leetcode;

import static com.yusufaytas.leetcode.Utils.printMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life,
is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following
four rules (taken from the above Wikipedia article):

    Any live cell with fewer than two live neighbors dies, as if caused by under-population.
    Any live cell with two or three live neighbors lives on to the next generation.
    Any live cell with more than three live neighbors dies, as if by over-population..
    Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Write a function to compute the next state (after one update) of the board given its current state.
The next state is created by applying the above rules simultaneously to every cell in the current state,
where births and deaths occur simultaneously.

Example:

Input:
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output:
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]

Follow up:

    Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
    In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?


 */
public class GameOfLife {

  public static void main(String[] args) {
    final int[][] board = new int[][]{
        {0, 1, 0},
        {0, 0, 1},
        {1, 1, 1},
        {0, 0, 0}
    };
    new GameOfLife().gameOfLife(board);
    printMatrix(board);
  }

  public void gameOfLife(final int[][] board) {
    if (board == null || board.length == 0) {
      return;
    }
    final List<List<Integer>> updates = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        int alive = 0;
        for (int k = 0; k < 3; k++) {
          for (int l = 0; l < 3; l++) {
            if (i - 1 + k >= 0 && i - 1 + k < board.length && j - 1 + l >= 0
                && j - 1 + l < board[0].length) {
              if (k == 1 && l == 1) {
                continue;
              }
              if (board[i - 1 + k][j - 1 + l] == 1) {
                alive++;
              }
            }
          }
        }
        if (board[i][j] == 1 && (alive < 2 || alive > 3)) {
          updates.add(Arrays.asList(i, j, 0));
        }
        if (board[i][j] == 0 && alive == 3) {
          updates.add(Arrays.asList(i, j, 1));
        }
      }
    }
    for (int i = 0; i < updates.size(); i++) {
      board[updates.get(i).get(0)][updates.get(i).get(1)] = updates.get(i).get(2);
    }
  }
}
