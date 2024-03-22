package com.class21;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.class3.ListNode;

public class MergeKSortedList {
    public ListNode merge(List<ListNode> listOfLists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(11, new MyComparator());
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (ListNode node : listOfLists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        while (!minHeap.isEmpty()) {
            cur.next = minHeap.poll();
            if (cur.next.next != null) {
                minHeap.offer(cur.next.next);
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    static class MyComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            if (o1.val == o2.val) {
                return 0;
            }
            return o1.val < o2.val ? -1 : 1;
        }
        
    }
    
}
