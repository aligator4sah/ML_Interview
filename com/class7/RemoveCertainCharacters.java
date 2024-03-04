package com.class7;

import java.util.HashSet;
import java.util.Set;

public class RemoveCertainCharacters {
    public String remove(String input, String t) {
        char[] array = input.toCharArray();
        Set<Character> set = buildSet(t);
        // slow: [0, slow) contains the valid result
        // fast: [fast, array.length) is the area to explore
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (!set.contains(array[fast])) {
                array[slow++] = array[fast];
            }
        }
        return new String(array, 0, slow);
    }

    private Set<Character> buildSet(String t) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        return set;
    }
    
}
