package com.sortAndArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.synth.SynthStyle;

public class DigitSwitch {
    public int solution(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        
        int[] numberInput = convertToArray(S);
        List<Integer> solutions = new ArrayList<>();
        
        System.out.println("priginal value: " + Arrays.toString(numberInput));

        for (int i = 0; i < numberInput.length; i++) {
            // change the digit number in current index
            int digit = 0;
            int[] orgArray = convertToArray(S);
            while (digit <= 9) {
                orgArray[i] = digit;
                int sum = calculateSum(orgArray);
                if (sum % 3 == 0) {
                    solutions.add(sum);
                }
                System.out.println(sum);
                digit++;
            }
        }
        return solutions.size();
    }

    private int[] convertToArray(String S) {
        char[] charArray = S.toCharArray();
        int[] numberInput = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            numberInput[i] = charArray[i] - '0';
        }
        
        return numberInput;
    }

    private int calculateSum(int[] input) {
        int sum = 0;
        for (int j = 0; j < input.length; j++) {
            sum = sum * 10 + input[j];
        }
        return sum;
    }

    public static void main(String[] args) {
        DigitSwitch ds = new DigitSwitch();
        System.out.println(ds.solution("23"));
    }
    
}
