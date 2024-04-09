package com.class16;

import java.util.List;

public class NinetyFivePercentile {
    public int percentile95(List<Integer> lengths) {
        int[] count = new int[4097];
        for (int len : lengths) {
            count[len]++;
        }
        int sum = 0;
        int len = 4097;
        while (sum <= 0.05 * lengths.size()) {
            sum += count[--len];
        }
        return len;
    }
    
}
