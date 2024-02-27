package com.class5;

import java.util.LinkedList;
import java.util.Queue;

import com.class4.TreeNode;

public class CheckCompleted {
    public boolean isCompleted(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null) {
                flag = true;
            } else if(flag) {
                return false;
            } else {
                queue.offer(cur.left);
            }
            if (cur.right == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(cur.right);
            }
        }
        return true;

    }
}
