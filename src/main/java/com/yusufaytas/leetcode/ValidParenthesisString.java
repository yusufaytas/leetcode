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
    //first index, second parenthesis count
    final int[][] valid = new int[s.length()][s.length()];
    return checkValidString(s, 0, 0, valid);
  }

  //0 not computed 1 true -1 false
  public boolean checkValidString(final String s, final int index, final int count,
      final int[][] valid) {
    if (index == s.length()) {
      if (count == 0) {
        return true;
      }
      return false;
    }
    if (valid[index][count] != 0) {
      return valid[index][count] == 1;
    }
    boolean hasValid = false;
    final char c = s.charAt(index);
    if (c == '*') {
      hasValid = hasValid || checkValidString(s, index + 1, count, valid);
      if (!hasValid) {
        hasValid = hasValid || checkValidString(s, index + 1, count + 1, valid);
      }
      if (!hasValid && count != 0) {
        hasValid = hasValid || checkValidString(s, index + 1, count - 1, valid);
      }
    } else if (c == ')') {
      if (count == 0) {
        valid[index][count] = -1;
        return false;
      }
      hasValid = hasValid || checkValidString(s, index + 1, count - 1, valid);
    } else {
      hasValid = hasValid || checkValidString(s, index + 1, count + 1, valid);
    }
    valid[index][count] = hasValid ? 1 : -1;
    return hasValid;
  }

  public static void main(String[] args) {
    final String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
    System.out.println(new ValidParenthesisString().checkValidString(s));
  }
}
