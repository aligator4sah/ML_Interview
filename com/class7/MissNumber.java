package com.class7;

import java.util.HashSet;
import java.util.Set;

public class MissNumber {
    // Method 1: use HashSet
    public int missingI(int[] array) {
        int n = array.length + 1;
        Set<Integer> set = new HashSet<>();
        for (int number : array) {
            set.add(number);
        }
        for (int i = 1; i < n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return n;
    }

    // Method 2: use sum
    public int missingII(int[] array) {
        int n = array.length + 1;
        long targetSum = (n + 0L) * (n + 1) / 2;
        long actualSum = 0L;
        for (int num : array) {
            actualSum += num;
        }
        return (int)(targetSum - actualSum);
    }

    // Method 3: bit operation
    public int missingIII(int[] array) {
        int n = array.length + 1;
        int xor = 0;
        // xor 1 to n
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        for (int num : array) {
            xor ^= num;
        }
        return xor;
    }

    // Method 4: swap to the original position
    public int missingIV(int[] array) {
        // swap the numbers to its corresponding position
        // for numbrt x, the position is going to be x - 1
        for (int i = 0; i < array.length; i++) {
            while (array[i] != i + 1 && array[i] != array.length + 1) {
                swap(array, i, array[i] - 1);
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != i + 1) {
                return i + 1;
            }
        }

        return array.length + 1;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    
}
