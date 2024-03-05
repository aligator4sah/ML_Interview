package com.class8;

public class ReverseWordInSentence {
    public String reverseWords(String input) {
        char[] array = input.toCharArray();
        // 1. reverse the whole array
        reverse(array, 0, array.length - 1);
        int start = 0;
        // 2. reverse each words
        for (int i = 0; i < input.length(); i++) {
            // find the start index of the word
            if(array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
                start = i;
            }
            // find the end of the array
            if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
                reverse(array, start, i);
            }
        }
        return new String(array);
    }

    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
    
}
