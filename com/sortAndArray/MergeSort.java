package com.sortAndArray;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeSort {
    public int[] mergeSort(int[] array) {
        if (array == null) {
            return array;
        }

        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
        System.out.println(Arrays.toString(array));
    }

    private void merge(int[] array, int[] helper, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (helper[leftIndex] <= helper[rightIndex]) {
                array[left++] = helper[leftIndex++];
            } else {
                array[left++] = helper[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            array[left++] = helper[leftIndex++];
        }
    }

    public static void main(String[] args) {
        MergeSort solution = new MergeSort();

        int[] array = new int[]{4, 0, 5, -1, 45, 39, 18};
        array = solution.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

     public boolean isValid(String s) {
        LinkedList<Character> linkedList=new LinkedList<Character>();
        int n=s.length();
        if(n%2==1) return false;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch==')'){
                if(linkedList.size()==0||linkedList.getLast()!='(') return false;
                linkedList.removeLast();
            }else if(ch=='}'){
                if(linkedList.size()==0||linkedList.getLast()!='{') return false;
                linkedList.removeLast();                
            }else if(ch==']'){
                if(linkedList.size()==0||linkedList.getLast()!='[') return false;
                linkedList.removeLast();                
            }else{
                linkedList.addLast(ch);
            }
        }
        return linkedList.size()==0;}
}