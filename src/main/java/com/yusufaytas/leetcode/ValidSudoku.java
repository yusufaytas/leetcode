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

public class ValidSudoku {

  public static void main(String[] args) {
    final char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    System.out.println(new ValidSudoku().isValidSudoku(board));
  }

  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      final Set<Character> row = new HashSet<>();
      final Set<Character> column = new HashSet<>();
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.' && !row.add(board[i][j])) {
          return false;
        }
        if (board[j][i] != '.' && !column.add(board[j][i])) {
          return false;
        }
      }
    }
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        final Set<Character> square = new HashSet<>();
        for (int k = 0; k < 3; k++) {
          for (int l = 0; l < 3; l++) {
            if (board[k + i * 3][l + j * 3] != '.' && !square.add(board[k + i * 3][l + j * 3])) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }
}
