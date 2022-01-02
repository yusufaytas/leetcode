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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class GenerateParenthesis {

  public List<String> generateParenthesis(final int n) {
    final Set<String> pSet = new HashSet<>();
    generateParenthesis("", pSet, n, n);
    return new ArrayList<>(pSet);
  }

  public void generateParenthesis(
      final String parenthesis, final Set<String> all, final int right, final int left) {
    if (left == 0 && right == 0) {
      all.add(parenthesis);
      return;
    }
    if (left > right) {
      return;
    }
    if (right > 0) {
      generateParenthesis(parenthesis + ")", all, right - 1, left);
    }
    if (left > 0) {
      generateParenthesis(parenthesis + "(", all, right, left - 1);
    }
  }
}
