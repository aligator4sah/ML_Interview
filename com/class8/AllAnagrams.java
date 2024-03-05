package com.class8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {
    // find all anagrams of string s in string l, return all the starting indices
    public List<Integer> allAnagrams(String s, String l) {
        List<Integer> result = new ArrayList<>();
        if (l.length() == 0) {
            return result;
        }
        // when s is longer than l, there is no way any of the substring of l could be anagram of s
        if (s.length() > l.length()) {
            return result;
        }
        // map records the distinct character in s and their frequency
        Map<Character, Integer> map = countMap(s);
        // record how may distinct characters have been matched
        // only when a;; the distinct characters are matched, we found an anagram
        int match = 0;

        // keep a sliding window to move from left to right
        for (int i = 0; i < l.length(); i++) {
            // handle the new added character(rightmost) at the current sliding window
            char tmp = l.charAt(i);
            Integer count = map.get(tmp);
            if (count != null) {
                map.put(tmp, count - 1);
                if (count == 1) {
                    match++;
                }
            }
            // handle the left most characters at the previous sliding window
            if (i >= s.length()) {
                tmp = l.charAt(i - s.length());
                count = map.get(tmp);
                if (count != null) {
                    map.put(tmp, count + 1);
                    if (count == 0) {
                        match--;
                    }
                }
            }
            // for the current sliding window, if all the distinct characters are matched
            if (match == map.size()) {
                result.add(i - s.length() + 1);
            }
        }
        return result;
    }

    private Map<Character, Integer> countMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            Integer count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }
        return map;
    }
    
}
