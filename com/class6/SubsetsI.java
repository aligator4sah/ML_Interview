package com.class6;

import java.util.List;
import java.util.ArrayList;

/**
 * There are no duplicate characters in the given string
 */
public class SubsetsI {
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        // record the cutrent subset
        StringBuilder sb = new StringBuilder();
        helper(arraySet, sb, 0, result);
        return result;
    }

    private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
        //terminate condition
        if (index == set.length) {
            result.add(sb.toString());
            return;
        }
        // case 1: not pick the character at index
        helper(set, sb, index + 1, result);
        // case 2: pick the character at the index
        helper(set, sb.append(set[index]), index + 1, result);
        // reomve the added character when back track to previous
        sb.deleteCharAt(sb.length() - 1);
    }

    // another dfs solution
    public List<String> subSetsII(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helperII(arraySet, sb, 0, result);
        return result;
    }

    private void helperII(char[] set,StringBuilder sb, int index, List<String> result) {
        result.add(sb.toString());
        // maintain the ascending order of the indices of picked characters
        // choose next picked index
        for (int i = index; i < set.length; i++) {
            sb.append(set[index]);
            helperII(set, sb, i + 1, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
}
