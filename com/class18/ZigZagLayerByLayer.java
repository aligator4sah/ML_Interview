package com.class18;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.class4.TreeNode;

public class ZigZagLayerByLayer {
    public List<Integer> zipZag(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        deque.offerFirst(root);
        int layer = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if (layer == 0) {
                    // at even layer, from right to left
                    TreeNode tmp = deque.pollLast();
                    list.add(tmp.val);
                    if (tmp.right != null) {
                        deque.offerFirst(tmp.right);
                    }
                    if (tmp.left != null) {
                        deque.offerFirst(tmp.left);
                    }
                } else {
                    // at odd layer, from left to right
                    TreeNode tmp = deque.pollFirst();
                    list.add(tmp.val);
                    if (tmp.left != null) {
                        deque.offerLast(tmp.left);
                    }
                    if (tmp.right != null) {
                        deque.offerLast(tmp.right);
                    }
                }
            }
            layer = 1 - layer;
        }
        return list;
        
    }
    
}
