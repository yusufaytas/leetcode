package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are
those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.
 */
public class WordSearch2 {

  public static void main(String[] args) {
    final char[][] board = {
        {'o', 'a', 'a', 'n'},
        {'e', 't', 'a', 'e'},
        {'i', 'h', 'k', 'r'},
        {'i', 'f', 'l', 'v'}
    };
    final String[] words = {"oath", "pea", "eat", "rain"};

    System.out.println(new WordSearch2().findWords(board, words));
  }

  public List<String> findWords(char[][] board, String[] words) {
    Trie trie = new Trie();
    for (int i = 0; i < words.length; i++) {
      trie.insert(words[i]);
    }
    Set<String> wordsInBoard = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        boolean[][] visited = new boolean[board.length][];
        for (int k = 0; k < board.length; k++) {
          visited[k] = new boolean[board[0].length];
        }
        findWordByIndex(board, visited, trie, wordsInBoard, "", i, j);
      }
    }
    return new ArrayList<>(wordsInBoard);
  }

  public void findWordByIndex(char[][] board, boolean[][] visited,
      Trie words, Set<String> wordsInBoard,
      String currentString, int i, int j) {
    if (words.search(currentString)) {
      wordsInBoard.add(currentString);
    }
    if (j >= board[0].length || i >= board.length || j < 0 || i < 0) {
      return;
    }
    if (visited[i][j]) {
      return;
    }
    if (!words.startsWith(currentString)) {
      return;
    }
    char current = board[i][j];
    visited[i][j] = true;
    findWordByIndex(board, visited, words, wordsInBoard, currentString + current, i + 1, j);
    findWordByIndex(board, visited, words, wordsInBoard, currentString + current, i, j + 1);

    findWordByIndex(board, visited, words, wordsInBoard, currentString + current, i - 1, j);
    findWordByIndex(board, visited, words, wordsInBoard, currentString + current, i, j - 1);
    visited[i][j] = false;
  }

}
