package com.class16;

public class RandomThousand {
    public int random1000() {
        while (true) {
            int num = 0;
            // the following lines of code is usually used to compute
            // a0*x^0 + a1*x^1 + a2*x^2...ak*x^k
            for (int i = 0; i < 5; i++) {
                num = num * 5 + RandomFive.random5();
            }
            // choose 3000 insted of 1000 to reduce the # of expected random5() calls
            if (num < 3000) {
                return num % 1000;
            }
        }
    }
    
}
