package com.class16;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedReserviorSampling {
    private final int k;
    private int count;
    private List<Integer> sample;

    public GeneralizedReserviorSampling(int k) {
        // validation
        if (k <= 0) {
            throw new IllegalArgumentException("k must be > 0");
        }
        this.k = k;
        this.count = 0;
        sample = new ArrayList<Integer>();
    }

    public void read(int value) {
        count++;
        if (count <= k) {
            // for the first k elements, we just add them into the sample list
            sample.add(value);
        } else {
            int random = (int) (Math.random() * count);
            // for the recent read element, it should have the probability of k/count to be as the samples
            if (random < k) {
                // replace the sample at the corresponding position
                sample.set(random, value);
            }
        }
    }

    public List<Integer> sample() {
        return sample;
    }
    
}
