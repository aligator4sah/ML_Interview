package com.class22;

import com.class4.TreeNode;

// two nodes can be any nodes and they can only be the path from root to one of the leaf nodes
public class MaxPathSumBinaryTreeIII {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left, max);
        int right = helper(root.right, max);
        int sin = Math.max(Math.max(left, right), 0) + root.val;
        max[0] = Math.max(max[0], sin);
        return sin;
    }
    
    
}
