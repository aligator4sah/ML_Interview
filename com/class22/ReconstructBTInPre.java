package com.class22;

import java.util.HashMap;
import java.util.Map;

import com.class4.TreeNode;

public class ReconstructBTInPre {
    // Method 1: utilizing the inOrder sequence to determine the size of the left and right subtree
    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
        // key: node value, value: index in the inOrder array
        Map<Integer, Integer> inOrderMap = indexMap(inOrder);
        return helper(preOrder, inOrderMap, 0, inOrder.length - 1, 0, preOrder.length - 1);
    }

    private TreeNode helper(int[] preOrder, Map<Integer, Integer> inOrderMap, int inLeft, int inRight, int preLeft, int preRight) {
        if (inLeft > inRight) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preLeft]);
        // get the position of the root in inOrder sequence, 
        // so that we will know the size of left / right subtree
        int inMid = inOrderMap.get(root.val);
        root.left = helper(preOrder, inOrderMap, inLeft, inMid - 1, preLeft + 1, preLeft + inMid - inLeft);
        root.right = helper(preOrder, inOrderMap, inMid + 1, inRight, preRight + inMid - inRight + 1, preRight);
        return root;
    }

    private Map<Integer, Integer> indexMap(int[] in) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inMap.put(in[i], i);
        }
        return inMap;
    }

    // Method 2: linear solution
    public TreeNode reconstructII(int[] inOrder, int[] preOrder) {
        int[] preIndex = new int[]{0};
        int[] inIndex = new int[]{0};
        return helperII(preOrder, inOrder, preIndex, inIndex, Integer.MAX_VALUE);
    }

    private TreeNode helperII(int[] pre, int[] in, int[] preIndex, int[] inIndex, int target) {
        if (inIndex[0] >= in.length || in[inIndex[0]] == target) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preIndex[0]]);
        preIndex[0]++;
        root.left = helperII(pre, in, preIndex, inIndex, root.val);
        inIndex[0]++;
        root.right = helperII(pre, in, preIndex, inIndex, target);
        return root;

    }
    
}
