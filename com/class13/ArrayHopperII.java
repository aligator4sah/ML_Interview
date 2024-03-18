package com.class13;

public class ArrayHopperII {
    // Method 1 : DP
    public int minJump(int[] array) {
        int length = array.length;
        // minJump record the min number of jumps from 0 to each of the indices
        int[] minJump = new int[length];
        minJump[0] = 0;
        for (int i = 1; i < length; i++) {
            minJump[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (j + array[j] >= i && minJump[j] != -1) {
                    if (minJump[i] == -1 || minJump[i] > minJump[j] + 1) {
                        minJump[i] = minJump[j] + 1;
                    }
                }
            }
        }
        return minJump[length - 1];
    }

    // Method 2: greedy solution 
    public int minJumpII(int[] array) {
        if (array.length == 1) {
            return 0;
        }
        int jump = 0;
        // max index by current # of jumps
        int cur = 0;
        // max index by current + 1 # of jumps
        int next = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > cur) {
                jump++;
                if (cur == next) {
                    return -1;
                }
                cur = next;
            }
            next = Math.max(next, array[i] + i);
        }
        return jump;
    }

    
}
