package com.class7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonNumbers {
    // Assumption: there could be duplicate elements in the given array
    // Method 1 : two pointers
    public List<Integer> commonI(int[] a, int[] b) {
        List<Integer> common = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                common.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return common;
    }

    // Method 2: use HashMap
    public List<Integer> commonII(int[] a, int[] b) {
        List<Integer> common = new ArrayList<>();
        Map<Integer, Integer> countA = new HashMap<>();
        for (int num : a) {
            Integer freq = countA.getOrDefault(num, 0);
            countA.put(num, freq + 1);
        }
        Map<Integer, Integer> countB = new HashMap<>();
        for (int num : b) {
            Integer freq = countB.getOrDefault(num, 0);
            countB.put(num, freq + 1);
        }
        for (Map.Entry<Integer, Integer> entry : countA.entrySet()) {
            Integer ctInB = countB.get(entry.getKey());
            if (ctInB != null) {
                int appear = Math.min(entry.getValue(), ctInB);
                for (int i = 0; i < appear; i++) {
                    common.add(entry.getKey());
                }
            }
        }
        return common;
    }
    
}
