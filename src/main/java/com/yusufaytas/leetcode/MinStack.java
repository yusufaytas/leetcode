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
