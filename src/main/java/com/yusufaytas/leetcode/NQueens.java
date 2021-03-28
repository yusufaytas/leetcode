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
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard
such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement,
where 'Q' and '.' both indicate a queen and an empty space, respectively.
Q . . . .
. . . Q .
. Q . . .
. . . . Q
. . Q . .
 */
public class NQueens {
    public List<List<String>> solveNQueens(final int n) {
        final List<List<String>> queens = new ArrayList<>();
        solveNQueens(queens, new ArrayList<>(), n);
        return queens;
    }

    public void solveNQueens(final List<List<String>> queens,
                             final List<Integer> indexes,
                             final int n) {
        if (doesAttack(indexes)) {
            return;
        }
        if (indexes.size() == n) {
            queens.add(indexesToString(indexes));
        }
        final Set<Integer> remainingIndexes = IntStream.range(0, n).boxed()
                .collect(Collectors.toSet());
        remainingIndexes.removeAll(indexes);
        for (final int index : remainingIndexes) {
            indexes.add(index);
            solveNQueens(queens, indexes, n);
            indexes.remove(indexes.size() - 1);
        }
    }

    private boolean doesAttack(final List<Integer> indexes) {
        if (indexes.isEmpty()) {
            return false;
        }
        final int lastIndex = indexes.get(indexes.size() - 1);
        for (int i = indexes.size() - 2, j = 1; i >= 0; i--, j++) {
            if (indexes.get(i) == lastIndex - j || indexes.get(i) == lastIndex + j) {
                return true;
            }
        }
        return false;
    }

    public List<String> indexesToString(final List<Integer> indexes) {
        final List<String> lines = new ArrayList<>(indexes.size());
        for (int i = 0; i < indexes.size(); i++) {
            final StringBuilder builder = new StringBuilder();
            for (int j = 0; j < indexes.size(); j++) {
                builder.append(indexes.get(i) == j ? 'Q' : '.');
            }
            lines.add(builder.toString());
        }
        return lines;
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(2));
    }
}
