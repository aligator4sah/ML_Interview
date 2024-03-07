package com.class11;

public class HexRepresentation {
    // Assumption: number >= 0
    public String hex(int number) {
        String prefix = "0x";
        // handle the special case of 0 first
        if (number == 0) {
            return prefix + "0";
        }
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int rem = number % 16;
            if (rem < 10) {
                sb.append((char)('0' + rem));
            } else {
                sb.append((rem - 10 + 'A'));
            }
            number >>>= 4;
        }
        // reverse it all at last so in all comlexity is O(n)
        return prefix + sb.reverse().toString();
    }
    
}
