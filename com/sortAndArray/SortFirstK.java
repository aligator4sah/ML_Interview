package com.sortAndArray;

import java.util.Arrays;
import java.util.Collections;

public class SortFirstK {
    public static int[]  funcSort(int[] inputList, int num)
	{
		//int[]  answer = new int[inputList.length];
		// Write your code here
		// put the first k element into a min heap with size 
		Arrays.sort(inputList, 0, num);
        Arrays.sort(inputList, num + 1, inputList.length);
		reverseOrder(inputList, num, inputList.length - 1);
        int[] answer = Arrays.copyOf(inputList, inputList.length);
		return answer;
	}

    private static void reverseOrder(int[] array, int start, int end) {
        // int i, k, t; 
        // int left = start;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] inputList  = new int[]{11, 7, 5, 10, 46, 23, 16, 8};
        System.out.println(Arrays.toString(funcSort(inputList, 3)));
    }
    
}
