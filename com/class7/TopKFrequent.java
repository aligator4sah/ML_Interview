package com.class7;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    // Assumption: combo is not null, and k >= 1
    public String[] topKFrequent(String[] combo, int k) {
        // corner case
        if (combo.length == 0) {
            return new String[0];
        }
        // key: distinct strings, value: frequencies
        Map<String, Integer> freqMap = getFreqMap(combo);
        // minHeap on the frequencies of the strings
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        });
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        // sort the array
        return freqArray(minHeap);
    }

    private Map<String, Integer> getFreqMap(String[] combo) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String s : combo) {
            Integer freq = freqMap.getOrDefault(s, 0);
            freqMap.put(s, freq + 1);
        }
        return freqMap;
    }

    private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
        String[] results = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            results[i] = minHeap.poll().getKey();
        }
        return results;
    }
    
}
