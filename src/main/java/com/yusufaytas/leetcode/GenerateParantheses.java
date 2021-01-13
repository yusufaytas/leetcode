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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
{{REVISIT}}
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
public class GenerateParantheses {

  public List<String> generateParenthesis(int n) {
    Set<String> parantheses = new HashSet<String>();
    generateParenthesis("", parantheses, n, n);
    return new ArrayList<String>(parantheses);
  }

  public void generateParenthesis(String parantheses, Set<String> all, int right, int left) {
    if (left == 0 && right == 0) {
      all.add(parantheses);
      return;
    }
    if (left > right) {
      return;
    }
    if (right > 0) {
      generateParenthesis(parantheses + ")", all, right - 1, left);
    }
    if (left > 0) {
      generateParenthesis(parantheses + "(", all, right, left - 1);
    }
  }

}
