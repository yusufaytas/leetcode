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
    int max = 0, currentMax = 0, stackSize = 0;
    final Deque<int[]> stackSizes = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      final char c = s.charAt(i);
      if (c == ')') {
        if (stackSize == 0) {
          stackSizes.clear();
          currentMax = 0;
          continue;
        }
        stackSize--;
        if(stackSizes.peek()[0] == stackSize){
          currentMax += stackSizes.pop()[1];
        }
        currentMax += 2;
      } else {
        stackSizes.push(new int[]{stackSize, currentMax});
        currentMax = 0;
        stackSize++;
      }
      max = Math.max(currentMax, max);
    }
    return max;
  }

  public static void main(String[] args) {
    final String s = ")()())()()(";
    System.out.print(new LongestValidParentheses().longestValidParentheses(s));
  }
}
