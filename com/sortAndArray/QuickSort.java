package com.sortAndArray;

import java.util.Arrays;

public class QuickSort {
    public int[] quickSort(int[] array) {
        // check null first
        if (array == null) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        // define a pivot which will be used to partition the array
        int pivotPos = partition(array, left, right);
        quickSort(array, left, pivotPos - 1);
        quickSort(array, pivotPos + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int pivotIndex = left + (int)(Math.random() * (right  - left + 1));
        int pivot = array[pivotIndex];

        // swap the ivot elements to the rightmost position first
        swap(array, pivotIndex, right);
        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (array[leftBound] < pivot) {
                leftBound++;
            } else if (array[rightBound] > pivot) {
                rightBound--;
            } else {
                swap(array, leftBound++, rightBound--);
            }
        }
        // swap back the pivot element
        swap(array, leftBound, right);
        return leftBound;

    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();

        int[] array = new int[]{3, 9, 40, 12, 39};
        array = solution.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
    
    
}
