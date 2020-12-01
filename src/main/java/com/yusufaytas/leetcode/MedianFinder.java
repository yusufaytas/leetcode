package com.yusufaytas.leetcode;

import java.util.Arrays;

/*
 Find Median from Data Stream

Median is the middle value in an ordered integer list. If the size of the list is even,
there is no middle value. So the median is the mean of the two middle value.
For example,

[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

    void addNum(int num) - Add a integer number from the data stream to the data structure.
    double findMedian() - Return the median of all elements so far.

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2

Follow up:

    If all integer numbers from the stream are between 0 and 100, how would you optimize it?
    If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
public class MedianFinder {

  int size = 0;
  int[] integers = new int[64];

  public MedianFinder() {

  }

  public static void main(String[] args) {
    MedianFinder medianFinder = new MedianFinder();
    medianFinder.addNum(-1);
    medianFinder.addNum(-2);
    System.out.println(medianFinder.findMedian());
    medianFinder.addNum(-3);
    System.out.println(medianFinder.findMedian());
    medianFinder.addNum(-4);
    medianFinder.addNum(-5);
    System.out.println(medianFinder.findMedian());
  }

  public void addNum(final int num) {
    if (integers.length == size) {
      final int newSize = integers.length << 2;
      integers = Arrays.copyOf(integers, newSize);
    }
    integers[size] = num;
    for (int i = size; i > 0 && integers[i] < integers[i - 1]; i--) {
      int temp = integers[i];
      integers[i] = integers[i - 1];
      integers[i - 1] = temp;
    }
    size++;
  }

  public double findMedian() {
    final int mid = size / 2;
    if (size % 2 == 0) {
      return (integers[mid - 1] + integers[mid]) / 2.0;
    }
    return integers[mid];
  }
}
