package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
You have a group of people with their birth years and death years, how would you find the year with most people alive.

Example:
P1: 1982, 2017
P2: 1923, 2004
P3: 1988, 2015
P4: 1910, 1988
P5: 1990, 2005
P6: 2004, 2010

2004

B-1910 B-1923 B-1982 B-1988 D-1989 B-1990 B-2004 D-2005 D-2006 D-2011 D-2016 D-2018
   1      2      3     4      3       4     5      4      3      2      1      0
 */
public class MaximumPeopleAlive {

  public static void main(String[] args) {
    List<Person> people = new ArrayList<>();
    Person p1 = new Person(1982, 2017);
    Person p2 = new Person(1923, 2004);
    Person p3 = new Person(1988, 2015);
    Person p4 = new Person(1910, 1988);
    Person p5 = new Person(1990, 2005);
    Person p6 = new Person(2004, 2010);
    Collections.addAll(people, p1, p2, p3, p4, p5, p6);
    System.out.println(new MaximumPeopleAlive().findYears(people));
  }

  public int findYears(List<Person> people) {
    Map<Integer, Integer> years = new TreeMap<>();

    for (Person person : people) {
      if (!years.containsKey(person.birthYear)) {
        years.put(person.birthYear, 0);
      }
      years.put(person.birthYear, years.get(person.birthYear) + 1);

      if (!years.containsKey(person.deathYear + 1)) {
        years.put(person.deathYear + 1, 0);
      }
      years.put(person.deathYear + 1, years.get(person.deathYear + 1) - 1);
    }
    //maximum sub array
    int maxYear = 0, max = Integer.MIN_VALUE, current = 0;

    for (Map.Entry<Integer, Integer> entry : years.entrySet()) {
      int year = entry.getKey();
      int delta = entry.getValue();
      current += delta;
      if (current > max) {
        maxYear = year;
        max = current;
      }
    }

    return maxYear;
  }

  private static class Person {

    int birthYear;
    int deathYear;
    public Person(int birthYear, int deathYear) {
      this.birthYear = birthYear;
      this.deathYear = deathYear;
    }
  }
}
