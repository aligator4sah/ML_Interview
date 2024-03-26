package com.class22;

import com.class4.TreeNode;

public class MaxPathSumBTII {
    // path from any node to any node
    public int maxPathSum(TreeNode root) {
        int[] max = new int[] {Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }

    // return the maximum path sum of the "single" path
    private int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        left = left < 0 ? 0 : left;
        right = right < 0 ? 0 : right;
        max[0] = Math.max(max[0], left + right + root.val);
        return root.val + Math.max(left, right);
    }
    
}
