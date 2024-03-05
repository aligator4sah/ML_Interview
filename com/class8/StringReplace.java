package com.class8;

import java.util.List;

public class StringReplace {
    // Method 1: using char array to do it in place
    public String replaceI(String input, String s, String t) {
        char[] array = input.toCharArray();
        if (s.length() >= t.length()) {
            return replaceShorter(array, s, t);
        }
        return replaceLonger(array, s, t);
    }

    private String replaceShorter(char[] input, String s, String t) {
        int slow = 0;
        int fast = 0;
        while (fast < input.length) {
            if (fast <= input.length - s.length() && equalSubstring(input, fast, s)) {
                copySubstring(input, slow, t);
                slow += t.length();
                fast += s.length();
            } else {
                input[slow++] = input[fast++];
            }
        }
        return new String(input, 0, slow);
    }

    private String replaceLonger(char[] input, String s, String t) {
        List<Integer> matches = getAllMatches(input, s);
        // calculate the new length needed to add
        char[] result = new char[input.length + matches.size() * (t.length() - s.length())];
        // iterative from right to left
        // slow: the position for traversing the new length
        // fast: the position for tranversing the old length
        // lastIndex: the rightmost matching end position's index
        int lastIndex = matches.size() - 1;
        int fast = input.length- 1;
        int slow = result.length - 1;
        while (fast >= 0) {
            if (lastIndex >= 0 && fast == matches.get(lastIndex)) {
                copySubstring(result, slow - t.length() + 1, t);
                slow -= t.length();
                fast -= s.length();
                lastIndex--;
            } else {
                result[slow--] = input[fast--];
            }
        }
        return new String(result);
    }

    private boolean equalSubstring(char[] input, int fromIndex, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (input[fromIndex + i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // copy the string t to result at fromIndex
    private void copySubstring(char[] result, int fromIndex, String t) {
        for (int i = 0; i < t.length(); i++) {
            result[fromIndex + i] = t.charAt(i);
        }
    }

    // Method 2: using stringbuilder to append
    public String replaceII(String input, String s, String t) {
        StringBuilder sb = new StringBuilder();
        int fromIndex = 0;
        int matchIndex = input.indexOf(s, fromIndex);
        while (matchIndex != -1) {
            sb.append(input, fromIndex, matchIndex).append(t);
            fromIndex = matchIndex + s.length();
            matchIndex = input.indexOf(s, fromIndex);
        }
        sb.append(input, fromIndex, input.length());
        return sb.toString();
    }
    
}
