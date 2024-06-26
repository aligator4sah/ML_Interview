package com.class25;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FourSum {
    // Method 1: sort the array first, O(n ^ 3)
    public boolean exist(int[] array, int target) {
        // Assumption: array is not null, array.length >= 4
        Arrays.sort(array);
        for (int i = 0; i < array.length - 3; i++) {
            for (int j = i + 1; j < array.length - 2; j++) {
                int left = j + 1;
                int right = array.length - 1;
                int curTarget = target - array[i] - array[j];
                while (left < right) {
                    int sum = array[left] + array[right];
                    if (sum == curTarget) {
                        return true;
                    } else if (sum < curTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return false;
    }

    // each element records a pair of numbers in the array
    // left: the smaller index of the pair of numbers
    // right: the larger index of the pair of numbers
    // sum: the sum of the pair of numbers
    static class Element implements Comparable<Element> {
        int left;
        int right;
        int sum;

        Element(int left, int right, int sum) {
            this.left = left;
            this.right = right;
            this.sum = sum;
        }

        // the order of the element, sum > right index > left index
        @Override
        public int compareTo(Element another) {
            if (this.sum != another.sum) {
                return this.sum < another.sum ? -1 : 1;
            } else if (this.right != another.right) {
                return this.right < another.right ? -1 : 1;
            } else if (this.left != another.left) {
                return this.left < another.left ? -1 : 1;
            }
            return 0;
        }
    }

    // Method 2: O(n^2 * logn), get all pairs of numbers and apply 2 sum
    public boolean existII(int[] array, int target) {
        // split the tuple into two pair elements: (i, j) and (k, l)
        // so that array[i] + array[j] <= array[k] + array[l]
        Arrays.sort(array);
        Element[] pairSum = getPairSum(array);
        Arrays.sort(pairSum);
        int left = 0;
        int right = pairSum.length - 1;
        while (left < right) {
            if (pairSum[left].sum + pairSum[right].sum == target && pairSum[left].right < pairSum[right].left) {
                return true;
            } else if (pairSum[left].sum + pairSum[right].sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }


    private Element[] getPairSum(int[] array) {
        Element[] pairSum = new Element[array.length * (array.length - 1) / 2];
        int curIndex = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                pairSum[curIndex++] = new Element(j, i, array[i] + array[j]);
            }
        }
        return pairSum;
    }
    
    // each pair is representing a pair of numbers in the array by their index
    static class Pair {
        int left;
        int right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    // Method 3: HashMap O(n ^ 2)
    public boolean existIII(int[] array, int target) {
        Map<Integer, Pair> map = new HashMap<>();
        // the order of traversing i, j is not arbitrary, we should guarantee
        // we can always look at the pair with the smallest right index
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                int pairSum = array[j] + array[i];
                if (map.containsKey(target - pairSum) && map.get(target - pairSum).right < j) {
                    return true;
                }
                if (!map.containsKey(pairSum)) {
                    map.put(pairSum, new Pair(j, i));
                }
            }
        }
        return false;
    }
}
