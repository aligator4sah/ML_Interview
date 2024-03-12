package com.class10;

public class AbbrevMatch {
    // Method 1: recursive way
    public boolean match(String input, String pattern) {
        return match(input, pattern, 0, 0);
    }

    private boolean match(String s, String t, int si, int ti) {
        // only when we run out of the s and t at the same time.
        // there is a match
        if (si == s.length() && ti == t.length()) {
            return true;
        }
        // if there is something left in s while t is used up
        if (si >= s.length() || ti >= t.length()) {
            return false;
        }
        // case 1: if current char in t is not a digit
        if (t.charAt(ti) < '0' || t.charAt(ti) > '9') {
            if (s.charAt(si) == t.charAt(ti)) {
                return match(s, t, si + 1, ti + 1);
            }
            return false;
        }
        // case 2: if current char in t is a digit
        int count = 0;
        while (ti < t.length() && t.charAt(ti) >= '0' && t.charAt(ti) <= '9') {
            count = count * 10 + (t.charAt(ti) - '0');
            ti++;
        }
        return match(s, t, si + count, ti);
    }

    // Method 2: Iterative way
    public boolean matchII(String input, String pattern) {
        int si = 0;
        int ti = 0;
        while (si < input.length() && ti < input.length()) {
            if (pattern.charAt(ti) < '0' || pattern.charAt(ti) > '9') {
                if (input.charAt(si) != pattern.charAt(ti)) {
                    return false;
                }
                si++;
                ti++;
            } else {
                int count = 0;
                while (ti < pattern.length() && pattern.charAt(ti) >= '0' && pattern.charAt(ti) <= '9') {
                    count = count * 10 + (pattern.charAt(ti) - '0');
                    ti++;
                }
                si += count;
            }
        }
        return si == input.length() && ti == pattern.length();
    }
    
}
