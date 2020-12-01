package com.yusufaytas.leetcode;

import java.util.Stack;

/*
{{REVISIT}}
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {

  public int longestValidParentheses(String s) {
    int max = 0, index = 0;
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(i);
        continue;
      }
      if (stack.isEmpty()) {
        index = i + 1;
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          int currentMax = i - index + 1;
          max = Math.max(max, currentMax);
        } else {
          max = Math.max(max, i - stack.peek());
        }
      }
    }
    return max;
  }

}
