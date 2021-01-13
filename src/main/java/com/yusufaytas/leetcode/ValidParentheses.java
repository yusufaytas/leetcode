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
