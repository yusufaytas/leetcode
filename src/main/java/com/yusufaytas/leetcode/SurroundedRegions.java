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

import static com.yusufaytas.leetcode.Utils.printMatrix;

/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of
the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O'
on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells
connected horizontally or vertically.

 */
public class SurroundedRegions {

  public static void main(String[] args) {
    final char[][] board = new char[][]{
        {'X', 'X', 'X', 'X'},
        {'X', 'O', 'O', 'X'},
        {'X', 'X', 'O', 'X'},
        {'X', 'O', 'X', 'X'},
    };
    new SurroundedRegions().solve(board);
    printMatrix(board);
  }

  public void solve(char[][] board) {
    if (board == null || board.length == 0) {
      return;
    }
    for (int i = 1; i < board.length - 1; i++) {
      for (int j = 1; j < board[i].length - 1; j++) {
        if (board[i][j] == 'O') {
          if (isSurrounded(board, i, j)) {
            updateSurrounded(board, i, j, 'X');
          } else {
            updateSurrounded(board, i, j, 'O');
          }
        }
      }
    }
  }

  boolean isSurrounded(final char[][] board, final int i, final int j) {
    if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
      return false;
    }
    if (board[i][j] == 'V' || board[i][j] == 'X') {
      return true;
    }
    board[i][j] = 'V';
    return isSurrounded(board, i - 1, j) && isSurrounded(board, i + 1, j)
        && isSurrounded(board, i, j - 1) && isSurrounded(board, i, j + 1);
  }

  void updateSurrounded(final char[][] board, final int i, final int j, final char update) {
    if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
      return;
    }
    if (board[i][j] == 'V') {
      board[i][j] = update;
      updateSurrounded(board, i - 1, j, update);
      updateSurrounded(board, i + 1, j, update);
      updateSurrounded(board, i, j - 1, update);
      updateSurrounded(board, i, j + 1, update);
    }
  }
}
