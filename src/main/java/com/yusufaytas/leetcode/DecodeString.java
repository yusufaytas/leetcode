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
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside
the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and
that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"

 */
public class DecodeString {

  public static void main(String[] args) {
    final String s = "100[leetcode]";
    System.out.println(new DecodeString().decodeString(s));
  }

  public String decodeString(final String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    final Stack<Integer> multiplierStack = new Stack<>();
    final Stack<String> decodedStack = new Stack<>();
    int parsedMultiplier = 0;
    decodedStack.push("");
    for (int i = 0; i < s.length(); i++) {
      final Character c = s.charAt(i);
      if (c >= '0' && c <= '9') {
        parsedMultiplier = parsedMultiplier * 10 + c - '0';
        continue;
      }
      if (c == '[') {
        multiplierStack.push(parsedMultiplier);
        parsedMultiplier = 0;
        decodedStack.push("");
        continue;
      }
      if (c == ']') {
        final int multiplier = multiplierStack.pop();
        String multiplied = decodedStack.pop();
        String decoded = "";
        for (int j = 0; j < multiplier; j++) {
          decoded += multiplied;
        }
        decodedStack.push(decodedStack.pop() + decoded);
        continue;
      }
      decodedStack.push(decodedStack.pop() + c);
    }
    return decodedStack.pop();
  }
}
