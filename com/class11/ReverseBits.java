package com.class11;

public class ReverseBits {
    public int reverseI(int num) {
        for (int offset = 0; offset < 16; ++offset) {
            int right = (num >> offset) & 1;
            int left = (num >> (31 - offset)) & 1;
            if (left != right) {
                num ^= (1 << offset);
                num ^= (1 << (31 - offset));
            }
        }
        return num;
    }
    
}
