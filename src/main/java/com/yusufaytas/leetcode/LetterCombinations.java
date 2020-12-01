package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinations {

  private final static Map<Integer, String> LETTER_MAP = new HashMap<Integer, String>();

  static {
    LETTER_MAP.put(2, "abc");
    LETTER_MAP.put(3, "def");
    LETTER_MAP.put(4, "ghi");
    LETTER_MAP.put(5, "jkl");
    LETTER_MAP.put(6, "mno");
    LETTER_MAP.put(7, "pqrs");
    LETTER_MAP.put(8, "tuv");
    LETTER_MAP.put(9, "wxyz");
  }

  public static void main(String[] args) {
    System.out.println(new LetterCombinations().letterCombinations("23"));
  }

  public List<String> letterCombinations(String digits) {
    List<String> combinations = new ArrayList<String>();
    letterCombinations("", digits, combinations);
    return combinations;
  }

  public void letterCombinations(String combination, String digits, List<String> allCombinations) {
    if (digits == null || digits.length() == 0) {
      if (!combination.equals("")) {
        allCombinations.add(combination);
      }
      return;
    }
    int number = digits.charAt(0) - '0';
    String mapping = LETTER_MAP.get(number);

    for (int i = 0; i < mapping.length(); i++) {
      letterCombinations(combination + mapping.charAt(i), digits.substring(1), allCombinations);
    }
  }
}
