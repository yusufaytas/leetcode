package com.yusufaytas.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]

Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]

Example 3:

Input: ")("
Output: [""]

 */
public class RemoveInvalidParentheses {

  public static void main(final String[] args) {
    final String s = "l)((j())()()))((";
    System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses(s));
  }

  public List<String> removeInvalidParentheses(final String s) {
    final Queue<String> queue = new ArrayDeque<>();
    final Set<String> visited = new HashSet<>();
    final List<String> validParentheses = new ArrayList<>();
    queue.add(s);
    while (!queue.isEmpty()) {
      final String current = queue.poll();
      if (visited.contains(current)) {
        continue;
      }
      if (!validParentheses.isEmpty() && validParentheses.get(0).length() > current.length()) {
        break;
      }
      visited.add(current);
      if (hasValidParentheses(current)) {
        validParentheses.add(current);
      } else {
        for (int i = 0; i < current.length(); i++) {
          queue.add(current.substring(0, i) + current.substring(i + 1));
        }
      }
    }
    return validParentheses;
  }

  public boolean hasValidParentheses(final String s) {
    if (s.isEmpty()) {
      return true;
    }
    final Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push('(');
      } else if (s.charAt(i) != ')') {
        continue;
      } else if (stack.isEmpty()) {
        return false;
      } else {
        stack.pop();
      }
    }
    return stack.isEmpty();
  }

}
