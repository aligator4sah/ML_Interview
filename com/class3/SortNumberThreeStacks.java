package com.class3;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * The numbers are stored in stack 1 originally
 */
public class SortNumberThreeStacks {
    // Assumption: s1 is not null
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<>();
        LinkedList<Integer> s3 = new LinkedList<>();
        sort(s1, s2, s3, s1.size());
        while (!s1.isEmpty()) {
            System.out.println(s1.pollFirst());
        }
    }

    private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int length) {
        if (length <= 1) {
            return;
        }

        int mid1 = length / 2;
        int mid2 = length - length / 2;
        for (int i = 0; i < mid1; i++) {
            // put the first half into s2
            s2.offerFirst(s1.pollFirst());
        }
        sort(s2, s3, s1, mid1);
        sort(s1, s3, s2, mid2);
        int i = 0;
        int j = 0;
        while (i < mid1 && j < mid2) {
            if (s2.peekFirst() < s1.peekFirst()) {
                s3.offerFirst(s2.pollFirst());
                i++;
            } else {
                s3.offerFirst(s1.pollFirst());
                j++;
            }
        }
        while (i < mid1) {
            s3.offerFirst(s2.pollFirst());
        }
        while (j < mid2) {
            s3.offerFirst(s1.pollFirst());
        }

        for (int index = 0; index < length; index++) {
            s1.offerFirst(s3.pollFirst());
        }
    }

    public static void main(String[] args) {
        SortNumberThreeStacks solution = new SortNumberThreeStacks();
        LinkedList<Integer> stack1 = new LinkedList<>();

        stack1.add(3);
        stack1.add(29);
        stack1.add(43);
        // stack1.add(18);
        // stack1.add(0);
        // stack1.add(5);
        // stack1.add(34);
      
        solution.sort(stack1);
    }
    
}
