package com.class16;

public class RandomSeven {
    public int random7() {
        while (true) {
            // generate a uniformly distributed 0-24 number
            int random = 5 * RandomFive.random5() + RandomFive.random5();
            if (random < 21) {
                return random % 7;
            }
        }
    }

    public static void main(String[] args) {
        RandomSeven seven = new RandomSeven();
        System.out.println("Randome Seven: " + seven.random7());
    }
}

class RandomFive {
    static int num;

    public static int random5() {
        num = (int)(Math.random() * 5 + 1);
        System.out.println("Random Five: " + num);
       return num;
    }
}
