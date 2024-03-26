package com.class22;

import com.class4.TreeNode;

public class ReconstructBSTPosOrder {
    public TreeNode reconstruct(int[] post) {
        int[] index = new int[]{post.length - 1};
        return helper(post, index, Integer.MIN_VALUE);
    }

    private TreeNode helper(int[] postOrder, int[] index, int min) {
        //BST, min is the root
        // using root value to determine the boundary of the left and right subtree
        if (index[0] < 0 || postOrder[index[0]] <= min) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[index[0]--]);
        root.right = helper(postOrder, index, root.val);
        root.left = helper(postOrder, index, min);
        return root;
    }
}
