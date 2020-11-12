package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Implement the RandomizedSet class:

    bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
    bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
    int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.

Follow up: Could you implement the functions of the class with each function works in average O(1) time?

Example 1:

Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.

Constraints:

    -231 <= val <= 231 - 1
    At most 105 calls will be made to insert, remove, and getRandom.
    There will be at least one element in the data structure when getRandom is called.

//TODO: look at this, deleting the last element with replacement value is tricky.
 */
public class InsertDeleteGetRandom
{
    /**
     * Initialize your data structure here.
     */

    final Map<Integer, Integer> mapToIndex;
    final List<Integer> values;

    public InsertDeleteGetRandom()
    {
        mapToIndex = new HashMap<>();
        values = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(final int val)
    {
        if (mapToIndex.containsKey(val))
        {
            return false;
        }
        mapToIndex.put(val, values.size());
        values.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(final int val)
    {
        if (mapToIndex.containsKey(val))
        {
            final int replacementValue = values.get(values.size() - 1);
            final int usedIndex = mapToIndex.remove(val);
            if (usedIndex != values.size() - 1)
            {
                mapToIndex.put(replacementValue, usedIndex);
                values.set(usedIndex, replacementValue);
            }
            values.remove(values.size() - 1);
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom()
    {
        return values.get((int) (values.size() * Math.random()));
    }

    public static void main(String[] args)
    {
        final InsertDeleteGetRandom random = new InsertDeleteGetRandom();
        random.insert(0);
        random.insert(1);
        random.remove(0);
        random.insert(2);
        random.remove(1);
        System.out.println(random.getRandom());
    }
}
