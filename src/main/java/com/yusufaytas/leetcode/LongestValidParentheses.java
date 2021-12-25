/**
 * Copyright © 2021 Yusuf Aytas. All rights reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yusufaytas.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
{{REVISIT}}
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {

  // Examples: )()())((())), ()(()
  public int longestValidParentheses(final String s) {
    int max = 0;
    final int[] maxes = new int[s.length()];
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          maxes[i] += (i > 1 ? maxes[i - 2] : 0) + 2;
        } else if (maxes[i - 1] > 0
            && i - 1 - maxes[i - 1] >= 0
            && s.charAt(i - 1 - maxes[i - 1]) == '(') {
          maxes[i] +=
              maxes[i - 1] + 2 + (i - 2 - maxes[i - 1] >= 0 ? maxes[i - 2 - maxes[i - 1]] : 0);
        }
      }
      max = Math.max(max, maxes[i]);
    }
    return max;
  }

  public static void main(String[] args) {
    final String s = "()(())";
    System.out.print(new LongestValidParentheses().longestValidParentheses(s));
  }
}
