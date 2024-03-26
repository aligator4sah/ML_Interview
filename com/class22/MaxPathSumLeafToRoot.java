package com.class22;

import com.class4.TreeNode;

public class MaxPathSumLeafToRoot {
    // Method 1: pass down the prefix sum
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return maxPathSum(root, 0);
    }

    private int maxPathSum(TreeNode root, int sum) {
        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else if (root.left == null) {
            return maxPathSum(root.right, sum);
        } else if (root.right == null) {
            return maxPathSum(root.left, sum);
        }
        return Math.max(maxPathSum(root.left, sum), maxPathSum(root.right, sum));
    }

    // Method 2: Bottom up return the max suffix sum
    public int maxPathSumII(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        } else if (root.left == null) {
            return maxPathSum(root.right) + root.val;
        } else if (root.right == null) {
            return maxPathSum(root.left) + root.val;
        }
        return root.val + Math.max(maxPathSum(root.left), maxPathSum(root.right));
    }
    
}
