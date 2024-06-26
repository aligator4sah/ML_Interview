package com.class27;

public class InterleaveStrings {
    public boolean canMerge(String a, String b, String c) {
        int alen = a.length();
        int blen = b.length();
        int clen = c.length();
        if (alen + blen != clen) {
            return false;
        }

        boolean[][] canMerge = new boolean[alen + 1][blen + 1];
        for (int i = 0; i <= alen; i++) {
            for (int j = 0; j <= blen; j++) {
                // this is the only base case we need to take care
                if (i == 0 && j == 0) {
                    canMerge[i][j] = true;
                }
                // 2 possible ways of matching the character in c
                if (i > 0 && a.charAt( - 1) == c.charAt(i + j - 1)) {
                    canMerge[i][j] |= canMerge[i - 1][j];
                }
                if (j > 0 && b.charAt(j - 1) == c.charAt(i + j - 1)) {
                    canMerge[i][j] = canMerge[i][j - 1];
                }
            }
        }
        return canMerge[alen][blen];
    }
    
}
