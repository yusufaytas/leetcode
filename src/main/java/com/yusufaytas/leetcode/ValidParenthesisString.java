package com.yusufaytas.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 Given a string containing only three types of characters: '(', ')' and '*',
 write a function to check whether this string is valid. We define the validity of a string by these rules:

    Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    Any right parenthesis ')' must have a corresponding left parenthesis '('.
    Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
    An empty string is also valid.

Example 1:

Input: "()"
Output: True

Example 2:

Input: "(*)"
Output: True

Example 3:

Input: "(*))"
Output: True

 */
public class ValidParenthesisString {

  public boolean checkValidString(final String s) {
    if (s == null || s.isEmpty()) {
      return true;
    }
    return checkValidString(s, 0, new ArrayDeque<>());
  }

  public boolean checkValidString(final String s, final int index, final Deque<Character> stack) {
    if (index == s.length()) {
      if (stack.isEmpty()) {
        return true;
      }
      return false;
    }
    boolean hasValid = false;
    final char c = s.charAt(index);
    if (c == '*') {
      final Deque<Character> skipStack = new ArrayDeque<>(stack);
      hasValid = hasValid || checkValidString(s, index + 1, skipStack);
      if (!hasValid) {
        final Deque<Character> leftChar = new ArrayDeque<>(stack);
        leftChar.push('(');
        hasValid = hasValid || checkValidString(s, index + 1, leftChar);
      }
      if (!hasValid && !stack.isEmpty()) {
        final Deque<Character> rightChar = new ArrayDeque<>(stack);
        rightChar.pop();
        hasValid = hasValid || checkValidString(s, index + 1, rightChar);
      }
    } else if (c == ')') {
      if (stack.isEmpty()) {
        return false;
      }
      stack.pop();
      hasValid = hasValid || checkValidString(s, index + 1, stack);
    } else {
      stack.push('(');
      hasValid = hasValid || checkValidString(s, index + 1, stack);
    }
    return hasValid;
  }


  public static void main(String[] args) {
    final String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
    System.out.println(new ValidParenthesisString().checkValidString(s));
  }
}
