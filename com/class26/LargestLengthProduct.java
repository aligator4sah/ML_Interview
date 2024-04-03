package com.class26;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

// Given a dictionary containing many words.
// find the largest product of two words' length
// such that the two words do not share any common characters
public class LargestLengthProduct {
    public int largestProduct(String[] dict) {
        // the bit mask is represented by the lowest 26 bits of an integer
        // each of the bit represents one of the characters in 'a' - 'z'
        Map<String, Integer> bitMask = getBitMask(dict);
        // sort the dict by length of the words in descending order
        Arrays.sort(dict, new Comparator<String>(){
            @Override
            public int compare(String s0, String s1) {
                if (s0.length() == s1.length()) {
                    return 0;
                }
                return s0.length() < s1.length() ? -1 : 1;
            }
        });
        int largest = 0;
        for (int i = 1; i < dict.length; i++) {
            for (int j = 0; j < i; j++) {
                int prod = dict[i].length() * dict[j].length();
                if (prod <= largest) {
                    break;
                }
                int iMask = bitMask.get(i);
                int jMask = bitMask.get(j);
                if ((iMask & jMask) == 0) {
                    largest = prod;
                }
            }
        }
        return largest;
    }
    
    // generate the bit mask for each word
    private Map<String, Integer> getBitMask(String[] dict) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : dict) {
            int bitMask = 0;
            for (int i = 0; i < str.length(); i++) {
                bitMask |= 1 << (str.charAt(i -'a'));
            }
        }
        return map;
    }
}
