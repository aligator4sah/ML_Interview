package com.class4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GetRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> list = new ArrayList<>();
        getRange(root, min, max, list);
        return list;
    }

    private void getRange(TreeNode root, int min, int max, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.val > min) {
            getRange(root.left, min, max, list);
        }
        if (root.val >= min && root.val <= max) {
            list.add(root.val);
        }
        if (root.val < max) {
            getRange(root.right, min, max, list);
        }
    }
    
}
