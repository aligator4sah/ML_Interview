package com.class4;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreOrder {
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        if (root == null) {
            return preOrder;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
            preOrder.add(cur.val);
        }
        
        return preOrder;
    }
    
}
