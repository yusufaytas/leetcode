package com.yusufaytas.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

    Division between two integers should truncate toward zero.
    The given RPN expression is always valid. That means the expression would always evaluate to a result and
    there won't be any divide by zero operation.

Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation:
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */
public class EvaluateReversePolishNotation {

  public static void main(String[] args) {
    final String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens));
  }

  public int evalRPN(String[] tokens) {
    final Set<String> operators = new HashSet<>();
    operators.add("+");
    operators.add("-");
    operators.add("*");
    operators.add("/");
    if (tokens.length > 0) {
      final Stack<Integer> stack = new Stack<>();
      for (int i = 0; i < tokens.length; i++) {
        if (operators.contains(tokens[i])) {
          final int op2 = stack.pop();
          final int op1 = stack.pop();
          final int result = applyOperator(op1, op2, tokens[i]);
          stack.push(result);
        } else {
          stack.push(Integer.parseInt(tokens[i]));
        }
      }
      return stack.pop();
    }
    return 0;
  }

  private int applyOperator(int op1, int op2, String token) {
    if (token.equals("+")) {
      return op1 + op2;
    } else if (token.equals("-")) {
      return op1 - op2;
    } else if (token.equals("*")) {
      return op1 * op2;
    }
    return op1 / op2;
  }
}
