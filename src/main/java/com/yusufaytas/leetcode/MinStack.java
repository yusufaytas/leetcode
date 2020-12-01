package com.yusufaytas.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.



Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 */
public class MinStack {

  /**
   * initialize your data structure here.
   */
  final PriorityQueue<Integer> queue = new PriorityQueue<>();
  final List<Integer> list = new LinkedList<>();

  public MinStack() {

  }

  public void push(int x) {
    queue.add(x);
    list.add(0, x);
  }

  public void pop() {
    queue.remove(list.remove(0));
  }

  public int top() {
    return list.get(0);
  }

  public int getMin() {
    return queue.peek();
  }
}
