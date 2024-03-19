package com.class18;

import java.util.Arrays;

public class ArrayDeduplicationI {
    // sorted array, deduplicate and only retain one
    public int[] dedup(int[] array) {
        // Assumption: array is not null
        if (array.length <= 1) {
            return array;
        }

        //slow: from 0 to array[0] is alway valid, include the valid partition
        int end = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[end]) {
                array[++end] = array[i];
            }
        }
        return Arrays.copyOf(array, end + 1);
    }

    // sorted array, deduplicate the elements and only retain two
    public int[] dedupII(int[] array) {
        if (array.length <= 2) {
            return array;
        }
        int end = 1;
        for (int i = 2; i < array.length; i++) {
            if (array[i] != array[end - 1]) {
                array[++end] = array[i];
            }
        }
        return Arrays.copyOf(array, end + 1);
    }

    // sorted array, deduploicate the element and not retain any
    public int[] dedupIII(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int end = 0;
        // use flag to see if there is any duplicates of array[end]
       boolean flag = false;
       for (int i = 1; i < array.length; i++) {
        if (array[i] == array[end]) {
            // if there is duplicate, set flag and do nothing
            flag = true;
        } else if (flag) {
            array[end] = array[i];
            flag = false;
        } else {
            // if array[i] != array[end] and flag is not set
            // it means there is no duplicate 
            array[++end] = array[i];
        }
       }
       return Arrays.copyOf(array, flag ? end : end + 1);
    }

    // unsorted array, repeatedly deduplication
    public int[] dedupIV(int[] array) {
        // Assumption: array is not null
        int end = -1;
        for (int i = 0; i < array.length; i++) {
            // using the left part of original array as a stack
            if (end == -1 || array[end] != array[i]) {
                array[++end] = array[i];
            } else {
                // otherwise, we ignore all the consecutive duplications and 
                // remove the top element of the stack
                while (i + 1 < array.length && array[i + 1] == array[end]) {
                    i++;
                }
                end--;
            }
            return Arrays.copyOf(array, end + 1);
        }
    }
    
}
