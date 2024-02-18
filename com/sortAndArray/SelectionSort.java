package com.sortAndArray;

import java.util.Arrays;

public class SelectionSort {
    public int[] selectionSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
        return array;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        SelectionSort solution = new SelectionSort();

        int[] array = new int[]{1, 3, 4, 0, 49, 20, 5};
        array = solution.selectionSort(array);
        System.out.println(Arrays.toString(array));

    }
    
}
