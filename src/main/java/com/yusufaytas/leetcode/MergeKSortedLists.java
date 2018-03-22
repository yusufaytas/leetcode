package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists
{
    private static class ListNode
    {
        int val;
        ListNode next;

        ListNode(int x)
        {
            val = x;
        }

        @Override
        public String toString()
        {
            List<Integer> values = new ArrayList<>();
            ListNode current = this;
            while (current != null)
            {
                values.add(current.val);
                current = current.next;
            }
            return values.toString();
        }
    }

    public ListNode mergeKLists(ListNode[] lists)
    {
        if (lists == null || lists.length == 0)
        {
            return null;
        }
        List<ListNode> listNodes = Arrays.asList(lists).stream()
                .filter(listNode -> listNode != null).collect(Collectors.toList());
        ListNode currentList = null, mergedList = null;
        PriorityQueue<Integer> indexes = new PriorityQueue<>(Comparator.comparingInt(o -> listNodes.get(o).val));
        for (int i = 0; i < listNodes.size(); i++)
        {
            indexes.add(i);
        }
        while (!indexes.isEmpty())
        {
            int index = indexes.poll();
            ListNode listNode = new ListNode(listNodes.get(index).val);
            if (currentList == null)
            {
                currentList = listNode;
                mergedList = currentList;
            }
            else
            {
                currentList.next = listNode;
                currentList = currentList.next;
            }
            if (listNodes.get(index).next != null)
            {
                listNodes.set(index, listNodes.get(index).next);
                indexes.add(index);
            }
        }

        return mergedList;
    }

    public static void main(String[] args)
    {

        ListNode[] lists = new ListNode[3];
//        lists[0] = null;
//        lists[1] = null;
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(5);
        lists[0].next.next = new ListNode(7);
        lists[1] = new ListNode(2);
        lists[1].next = new ListNode(4);
        lists[2] = new ListNode(3);
        lists[2].next = new ListNode(6);
        System.out.println(new MergeKSortedLists().mergeKLists(lists));
    }
}
