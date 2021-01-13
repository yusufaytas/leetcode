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

import java.util.HashSet;
import java.util.Set;

/*
Given an m x n board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells,
where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

 */
public class WordSearch {

  public boolean exist(final char[][] board, final String word) {
    if (board == null || board.length == 0 || word == null || word.length() == 0) {
      return false;
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (exist(board, word, new HashSet<>(), i, j, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean exist(final char[][] board, final String word, Set<String> visited,
      final int i, final int j, int index) {
    if (index == word.length()) {
      return true;
    }
    if (i == board.length || j == board[0].length || i < 0 || j < 0) {
      return false;
    }
    final String key = i + "|" + j;
    if (!visited.add(key)) {
      return false;
    }
    if (board[i][j] == word.charAt(index) && (
        exist(board, word, visited, i + 1, j, index + 1)
            || exist(board, word, visited, i - 1, j, index + 1)
            || exist(board, word, visited, i, j + 1, index + 1)
            || exist(board, word, visited, i, j - 1, index + 1)
    )) {
      return true;
    }
    visited.remove(key);
    return false;
  }

  public static void main(String[] args) {
    final char[][] board = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'E', 'S'},
        {'A', 'D', 'E', 'E'}
    };
    final String word = "ABCESEEEFS";
    System.out.println(new WordSearch().exist(board, word));
  }
}
