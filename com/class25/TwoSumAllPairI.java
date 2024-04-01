package com.class25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumAllPairI {
    public List<List<Integer>> allPairs(int[] array, int target) {
        // Assumption: array is not null, array.length >= 2
        List<List<Integer>> result = new ArrayList<>();
        // key: number, value: list of all possible indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> indices = map.get(target - array[i]);
            if (indices != null) {
                for (int j : indices) {
                    result.add(Arrays.asList(j, i));
                }
            }
            // add current index i to all the possible indices for value of array[i]
            if (!map.containsKey(array[i])) {
                map.put(array[i], new ArrayList<Integer>());
            }
            map.get(array[i]).add(i);
        }
        return result;

        return result;
    }
    
}
