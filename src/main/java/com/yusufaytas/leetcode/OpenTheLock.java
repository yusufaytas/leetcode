package com.yusufaytas.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/*
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots:
'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around:
for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum
total number of turns required to open the lock, or -1 if it is impossible.



Example 1:

Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".

Example 2:

Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation:
We can turn the last wheel in reverse to move from "0000" -> "0009".

Example 3:

Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation:
We can't reach the target without getting stuck.

Example 4:

Input: deadends = ["0000"], target = "8888"
Output: -1

 */
public class OpenTheLock {

  public int openLock(final String[] deadends, final String target) {
    if (target == null || target.isEmpty() || deadends == null) {
      return -1;
    }
    final Queue<LockWheel> wheels = new PriorityQueue<>(
        Comparator.comparingInt(value -> value.level));
    final Set<String> ends = Arrays.asList(deadends).stream()
        .collect(Collectors.toSet());
    wheels.add(new LockWheel("0000", 0));
    while (!wheels.isEmpty()) {
      final LockWheel next = wheels.poll();
      if (next.wheel.equals(target)) {
        return next.level;
      }
      if (!ends.add(next.wheel)) {
        continue;
      }
      for (int i = 0; i < 4; i++) {
        wheels.add(new LockWheel(next.wheel.substring(0, i)
            + (char) (((next.wheel.charAt(i) - '0' + 11) % 10) + '0') + next.wheel.substring(i + 1),
            next.level + 1));
        wheels.add(new LockWheel(next.wheel.substring(0, i)
            + (char) (((next.wheel.charAt(i) - '0' + 9) % 10) + '0') + next.wheel
            .substring(i + 1),
            next.level + 1));
      }
    }
    return -1;
  }

  private static class LockWheel {

    final String wheel;
    final int level;

    public LockWheel(String wheel, int level) {
      this.wheel = wheel;
      this.level = level;
    }
  }

  public static void main(String[] args) {
    final String[] deadends = {"8888"};
    final String target = "0009";
    System.out.println(new OpenTheLock().openLock(deadends, target));
  }
}
