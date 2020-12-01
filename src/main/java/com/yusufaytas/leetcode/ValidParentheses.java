package com.yusufaytas.leetcode;

import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

  public static void main(String[] args) {
    System.out.println(new ValidParentheses().isValid("{()[]{}}"));
  }

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
      if (stack.isEmpty()) {
        stack.push(s.charAt(i));
      } else {
        char c = stack.peek();
        if ((c == '(' && s.charAt(i) == ')') ||
            (c == '{' && s.charAt(i) == '}') ||
            (c == '[' && s.charAt(i) == ']')) {
          stack.pop();
        } else {
          stack.push(s.charAt(i));
        }
      }
    }
    return stack.isEmpty();
  }
}
