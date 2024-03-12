package com.class12;

public class ArrayHopperI {
    // Method 1: DP, canJump[i] means from index 0, can jump to index i
    public boolean canJump(int[] array) {
        boolean[] canJump = new boolean[array.length];
        canJump[0] = true;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (canJump[j] && array[j] + j >= i) {
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[array.length - 1];
    }

    // method 2: DP, canJump[i] means from index i can jump to index array.length -1
    public boolean canJumpII(int[] array) {
        if (array.length == 1) {
            return true;
        }
        boolean[] canJump = new boolean[array.length];
        for (int i = array.length - 2; i >= 0; i--) {
            // if from index i, it is already possible to jump tp the end of the array
            if (i + array[i] >= array.length - 1) {
                canJump[i] = true;
                break;
            } else {
                // if any of the reachable indices from index i is reachable to the end of the
                // array
                for (int j = array[i]; j >= 1; j--) {
                    if (canJump[j + i]) {
                        canJump[i] = true;
                        break;
                    }
                }
            }
        }

        return canJump[0];
    }

    // method 3: greedy solution
    // keep the max index reachable by jumping x steps. and
    // the max index reachable by jumping x + 1 steps
    public boolean canJumpIII(int[] array) {

        if (array.length == 1) {
            return true;
        }

        // the max index jumping current steps can reach
        int cur = 0;
        // the max index jumping current + 1 steps can reach
        int next = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > cur) {
                if (cur == next) {
                    // there is no progress for using current + 1 jump steps
                    // in this case, we can never reach the end of the array
                    return false;
                }
                cur = next;
            }
            // update the max index jumping one more step can reach
            next = Math.max(next, i + array[i]);
        }
        return false;
    }
}
