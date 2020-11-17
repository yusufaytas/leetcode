package com.yusufaytas.leetcode;

import java.util.Stack;

/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces.
The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7

Example 2:

Input: " 3/2 "
Output: 1

Example 3:

Input: " 3+5 / 2 "
Output: 5

Note:

    You may assume that the given expression is always valid.
    Do not use the eval built-in library function.
 */
public class BasicCalculator2
{
    public int calculate(final String s)
    {
        final String cleaned = s.replaceAll("\\s", "");
        final Stack<Integer> numbers = new Stack<>();
        final Stack<Character> operators = new Stack<>();
        int current = 0;
        for (int i = 0; i < cleaned.length(); i++)
        {
            if (cleaned.charAt(i) <= '9' && cleaned.charAt(i) >= '0')
            {
                current = current * 10 + cleaned.charAt(i) - '0';
            }
            else
            {
                numbers.push(current);
                if (!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/'))
                {
                    int secondNumber = numbers.pop();
                    int firstNumber = numbers.pop();
                    current = operators.pop() == '*' ? firstNumber * secondNumber : firstNumber / secondNumber;
                    numbers.push(current);
                }
                operators.push(cleaned.charAt(i));
                current = 0;
            }
        }
        numbers.push(current);
        if (!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/'))
        {
            int secondNumber = numbers.pop();
            int firstNumber = numbers.pop();
            current = operators.pop() == '*' ? firstNumber * secondNumber : firstNumber / secondNumber;
            numbers.push(current);
        }
        current = 0;
        while (!operators.isEmpty())
        {
            current += operators.pop() == '-' ? -numbers.pop() : numbers.pop();
        }
        return numbers.pop() + current;
    }

    public static void main(String[] args)
    {
        final BasicCalculator2 calculator = new BasicCalculator2();
        System.out.println(calculator.calculate("0*0"));
    }
}
