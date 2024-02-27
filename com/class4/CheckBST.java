package com.class4;

public class CheckBST {
    public boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
        return isBST(root.left, min, root.val - 1) && isBST(root.right, root.val + 1 , max);
    }
    
}
