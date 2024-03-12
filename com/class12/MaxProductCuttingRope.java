package com.class12;

public class MaxProductCuttingRope {
    public int maxProduct(int length) {
        // Assumption: length >= 2
        if (length == 2) {
            return 1;
        }
        int[] array = new int[length + 1];
        array[1] = 0;
        array[2] = 1;
        for (int i = 3; i < array.length; i++) {
            // at least one of the partitions after cutting is <= i/2
            // we can pick that partition and find the max product
            for (int j = 1; j <= i / 2; j++) {
                // for other partition, we can choose not cut or cut
                array[i] = Math.max(array[i], j * Math.max(i - j, array[i - j]));
            }
        }
        return array[length];
    }
    
}
