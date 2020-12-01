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
