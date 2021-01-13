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
