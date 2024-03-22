package com.class21;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArray {
    public int[] merge(int[][] arrayOfArrays) {
        // Assumption: arrayOfArrays is not null
        PriorityQueue<Entry> minheap = new PriorityQueue<>(11, new MyComparator());
        int length = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            int[] array = arrayOfArrays[i];
            length += array.length;
            if (array.length != 0) {
                minheap.offer(new Entry(i, 0, array[0]));
            }
        }
        int[] result = new int[length];
        int cur = 0;
        while (!minheap.isEmpty()) {
            Entry tmp = minheap.poll();
            result[cur++] = tmp.value;
            if (tmp.y < arrayOfArrays[tmp.x].length) {
                tmp.value = arrayOfArrays[tmp.x][++tmp.y];
                minheap.offer(tmp);
            }
        }
        return result;
    }

    static class MyComparator implements Comparator<Entry> {

        @Override
        public int compare(Entry o1, Entry o2) {
           if (o1.value == o2.value) {
            return 0;
           }
           return o1.value < o2.value ? -1 : 1;
        }
        
    }

    static class Entry {
        // the row number
        int x;
        // the column number
        int y;
        // the corresponding value
        int value;

        Entry(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    
}
