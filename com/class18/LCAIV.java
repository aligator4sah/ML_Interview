package com.class18;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.class4.TreeNode;

public class LCAIV {
    // LCA with k nodes
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        // assumption: all the nodes in the list are guarenteed to be in the tree
        Set<TreeNode> set = new HashSet<>();
        return helper(root, set);
    }

    private TreeNode helper(TreeNode root, Set<TreeNode> set) {
        if (root == null) {
            return null;
        }
        if (set.contains(root)) {
            return root;
        }
        TreeNode l = helper(root.left, set);
        TreeNode r = helper(root.right, set);
        if (l != null && r != null) {
            return root;
        }
        return l != null ? l : r;
    }
    
}
