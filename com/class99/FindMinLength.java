package com.class99;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * sample: b a a b a c a a
 *         0 1 2 3 4 5 6 7
 * 
 * a 1, 2, 4, 6, 7, 9,    4,  --> 1, 7 --> 1 2 2 times 5/ 3
 * b 0, 3   2  1 time   2 / 3 items 1 time
 * c 5
 * 
 * 2   1 cut
 * 3   1 cut
 * 5   2 cut
 * 6   3 cut
 */
public class FindMinLength {

    public int findMinLength(String word) {
        if (word == null || word.length() == 0) {
            return 0;
        }

        Map<Character, List<Integer>> wordIndex = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            List<Integer> indexArray =  wordIndex.get(word.charAt(i));
            if (indexArray == null) {
                indexArray = new ArrayList<>();
            }
            indexArray.add(i);
            wordIndex.put(word.charAt(i), indexArray);
        }

        int minCount = 0;
        for (Map.Entry<Character, List<Integer>> entry : wordIndex.entrySet()) {
            List<Integer> entryFreq = entry.getValue();
            int size = entryFreq.size();
            if (size > 1) {
                minCount += size / 2;
                if (size % 3 == 2) {
                    minCount = minCount + 1;
                }
                
            }
        }
        return minCount;

    }

    public List<Integer> coprimeCount(List<Integer> A) {
        List<Integer> result = new ArrayList<>();
        if (A == null || A.size() == 0) {
            return result;
        }
        // key: current num, value: num of co-prime
        Map<Integer, Integer> primeMap = new HashMap<>();
        int largestNum = 0;

        for (Integer num : A) {
           result.add(findCoprime(num, primeMap, largestNum));
        }
        return result;
    }

    public int findCoprime(int n, Map<Integer, Integer> map, int largestNum) {
        int count = 0;

        if (n > largestNum) {
            for (int i = largestNum; i <= n; i++) {
                if (isCoPrime(i, n) == 1) {
                    count++;
                }
            }
            count += map.get(largestNum);
        } else {
            for (int i = 2; i < n; i++) {
                if (isCoPrime(i, n) == 1) {
                    count++;
                } 
            }
        }
        map.put(n, count);
        largestNum = Math.max(n, largestNum);
        return count;
    }

    public int isCoPrime(int a, int b) {
         // Everything divides 0  
         if (a == 0 || b == 0) {
            return 0; 
         }
         
       
     // base case 
     if (a == b) {
        return a; 
     }
         
       
     // a is greater 
     if (a > b) {
        return isCoPrime(a-b, b); 
     }
               
     return isCoPrime(a, b-a); 
    }

}
