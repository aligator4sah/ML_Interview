package com.class22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.class4.TreeNode;

public class ReconstructBTInLevel {
    public TreeNode reconstruct(int[] level, int[] inOrder) {
        // assume there is no duplication in the binary tree
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i], i);
        }
        List<Integer> lList = new ArrayList<>();
        for (int num : level) {
            lList.add(num);
        }
        return helper(lList, inMap);
    }

    private TreeNode helper(List<Integer> level, Map<Integer, Integer> inMap) {
        if (level.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(level.remove(0));
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int num : level) {
            if (inMap.get(num) < inMap.get(root.val)) {
                left.add(num);
            } else {
                right.add(num);
            }
        }
        root.left = helper(left, inMap);
        root.right = helper(right, inMap);
        return root;
    }
    
}
