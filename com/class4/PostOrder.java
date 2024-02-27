package com.class4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostOrder {
    public List<Integer> postOrderI(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            
            result.add(cur.val);
        }
        Collections.reverse(result);
        return result;
    }
}
