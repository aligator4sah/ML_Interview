package com.class25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumAllPairsII {
    // Method 1: sort the array first and use two pointers
    public List<List<Integer>> allPairs(int[] array, int target) {
        // Assumptions: array is not null, array.length >= 2
        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            // ignore all the consecutive duplicate values when we want to determine the smaller element of the pair
            if (left > 0 && array[left] == array[left - 1]) {
                left++;
                continue;
            }
            int cur = array[left] + array[right];
            if (cur == target) {
                result.add(Arrays.asList(array[left], array[right]));
                left++;
                right--;
            } else if (cur < target) {
                left++;
            } else {
                right--;
            }
            
        }
        return result;
        
    }

    // Method 2: use HashSet
    public List<List<Integer>> allPairsII(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // record the number of existence of the values
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            // if 2 * x == target, we need to make sure there is no duplicates
            // if x + y == target, we need to make sure this is the first time x and y occurs
            Integer count = map.get(num);
            if (num * 2 == target && count != null && count == 1) {
                result.add(Arrays.asList(num, num));
            } else if (map.containsKey(target - num) && count == null) {
                result.add(Arrays.asList(target - num, num));
            }
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, count + 1);
            }
        }
        return result;
    }
    
}
