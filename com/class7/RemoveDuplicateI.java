package com.class7;

public class RemoveDuplicateI {
    public String deDup(String input) {
        if (input == null) {
            return null;
        }
        char[] array = input.toCharArray();
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i] != array[end - 1]) {
                array[end++] = array[i];
            }
        }
        return new String(array, 0, end);
    }

    // remove the duplicate characters recursively
    public String deDupII(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        // end represents for the top of the implicit stack
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            // if the stack is empty or there is no duplicate chars
            // push the character to the stack
            if (end == -1 || array[i] != array[end]) {
                array[++end] = array[i];
            } else {
                // otherwise, pop the top element by end--
                // ignore all the consecutive duplicate chars
                end--;
                while (i + 1 < array.length && array[i] == array[i + 1]) {
                    i++;
                }
            }
        }
        return new String(array, 0, end + 1);
    }
    
}
