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
There are N students in a class. Some of them are friends, while some are not.
Their friendship is transitive in nature. For example, if A is a direct friend of B,
and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle
is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class.
If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not.
And you have to output the total number of friend circles among all the students.

Example 1:

Input:
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
The 2nd student himself is in a friend circle. So return 2.

[1,0,0,1],
[0,1,1,0],
[0,1,1,1],
[1,0,1,1]
 */
public class FriendCircles {

  public int findCircleNum(int[][] M) {
    if (M == null || M.length == 0) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < M.length; i++) {
      for (int j = 0; j < M[0].length; j++) {
        if (M[i][j] != 1) {
          continue;
        }
        visitCircle(M, i, j);
        count++;
      }
    }
    return count;
  }

  void visitCircle(final int M[][], final int i, final int j) {
    if (i < 0 || i == M.length || j < 0 || j == M.length || M[i][j] != 1) {
      return;
    }
    M[i][j] = 2;
    for (int k = 0; k < M.length; k++) {
      visitCircle(M, i, k);
      visitCircle(M, k, i);
    }
  }
}
