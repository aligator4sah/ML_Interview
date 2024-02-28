package com.class6;

import java.util.ArrayList;
import java.util.List;

public class ValidParenthesesI {
    public List<String> validParenthese(int k) {
        List<String> result = new ArrayList<>();
        // the final string contains 2k characters
        char[] cur = new char[k * 2];
        helper(cur, k, k, 0, result);
        return result;
    }

    private void helper(char[] cur, int left, int right, int index, List<String> result) {
        // terminate condition
        if (left == 0 && right == 0) {
            result.add(new String(cur));
            return;
        }
        if (left > 0) {
            cur[index] = '(';
            helper(cur, left - 1, right, index + 1, result);
        }
        if (right > left) {
            cur[index] = ')';
            helper(cur, left, right - 1, index + 1, result);
        }
    }
    
}
