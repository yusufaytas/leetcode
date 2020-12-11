package com.yusufaytas.leetcode;

import static com.yusufaytas.leetcode.Utils.printArray;

/*
Given a non negative integer number num. For every numbers i in the range
0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]

Example 2:

Input: 5
Output: [0,1,1,2,1,2]

Follow up:

    It is very easy to come up with a solution with run time O(n*sizeof(integer)).
    But can you do it in linear time O(n) /possibly in a single pass?
    Space complexity should be O(n).
    Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

 */
public class CountingBits {

  public int[] countBits(int num) {
    final int[] bits = new int[num + 1];
    for (int i = 0; i <= num; i++) {
      bits[i] = numBits(i);
    }
    return bits;
  }

  public int numBits(int num) {
    int count = 0;
    while (num != 0) {
      if (num % 2 == 1) {
        count++;
      }
      num = num / 2;
    }
    return count;
  }

  public static void main(String[] args){
    printArray(new CountingBits().countBits(5));
  }
}
