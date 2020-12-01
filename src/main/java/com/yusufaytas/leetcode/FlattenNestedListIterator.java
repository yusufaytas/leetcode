package com.yusufaytas.leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists. // You should not implement it,
 * or speculate about its implementation public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list. public
 * boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer //
 * Return null if this NestedInteger holds a nested list public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list // Return
 * null if this NestedInteger holds a single integer public List<NestedInteger> getList(); }
 */
public class FlattenNestedListIterator
    implements Iterator<Integer> {

  final Stack<Integer> nestedIntegers = new Stack<>();

  public FlattenNestedListIterator(final List<NestedInteger> nestedList) {
    flatten(nestedList);
  }

  private void flatten(final List<NestedInteger> nestedList) {
    for (int i = nestedList.size() - 1; i >= 0; i--) {
      if (nestedList.get(i).isInteger()) {
        nestedIntegers.add(nestedList.get(i).getInteger());
        continue;
      }
      flatten(nestedList.get(i).getList());
    }
  }

  @Override
  public Integer next() {
    return nestedIntegers.pop();
  }

  @Override
  public boolean hasNext() {
    return !nestedIntegers.isEmpty();
  }

  private interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
  }
}
