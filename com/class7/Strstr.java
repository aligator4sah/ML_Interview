package com.class7;

// Determine if one string is another's substring
public class Strstr {
    // Method 1: Naive solution
    public int strstrI(String large, String small) {
        if (large.length() < small.length()) {
            return -1;
        }
        if (small.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= large.length() - small.length(); i++) {
            if (equals(large, i, small)) {
                return i;
            }
            return -1;
        }
    }

    private boolean equals(String large, int start, String small) {
        for (int i = 0; i < small.length(); i++) {
            if (large.charAt(start + i) != small.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public int strstrII(String large, String small) {
        if (large.length() < small.length()) {
            return -1;
        }
        if (small.length() == 0) {
            return 0;
        }
        // we need a large prime as module end
        int largePrime = 101;
        // we also need a small prime to calculate the hash value
        int prime = 31;
        int seed = 1;
        int targetHash = small.charAt(0) % largePrime;
        for (int i = 1; i < small.length(); i++) {
            seed = moduleHash(seed, 0, prime, largePrime);
            targetHash = moduleHash(targetHash, small.charAt(i), prime, largePrime);
        }
        int hash = 0;
        for (int i = 0; i < small.length(); i++) {
            hash = moduleHash(hash, large.charAt(i), prime, largePrime);
        }
        if (hash == targetHash && equals(large, 0, small)) {
            return 0;
        }
        for (int i = 1; i <= large.length() - small.length(); i++) {
            hash = nonNegative(hash - seed * large.charAt(i - 1) % largePrime, largePrime);
            hash = moduleHash(hash, large.charAt(i + small.length() - 1), prime, largePrime);
            if (hash == targetHash && equals(large, i, small)) {
                return i;
            }
        }
        return -1;
    }

    private int moduleHash(int hash, int addition, int prime, int largePrime) {
        return (hash * prime % largePrime + addition) % largePrime;
    }

    private int nonNegative(int hash, int largePrime) {
        if (hash < 0) {
            hash += largePrime;
        }
        return hash;
    }
}
