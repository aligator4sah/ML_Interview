package com.class11;

/**
 * Determine if the letters in a word are all unique
 * Assumption:
 * We are using ASCII encoding and the number of the valid letter is 256
 */
public class AllUniqueChars {
    public boolean allUnique(String word) {
        // each int value represents 32 bits, so we need 8 ints to represents 256 bits
        int[] vec = new int[8];
        char[] array = word.toCharArray();
        for (char c : array) {
            if ((vec[c / 32] >>> (c % 32) & 1) != 0) {
                return false;
            }
            vec[c / 32] |= 1 << (c % 32);
        }
        return true;
    }
    
}
