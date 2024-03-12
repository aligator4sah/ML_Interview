package com.class10;

import com.class4.TreeNode;

public class LCAI {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        // Assumption: root is not null
        // one and two are guaranteed to be in the tree
        if (root == null) {
            return null;
        }

        // if root is one two, we can ignore the later recursion
        if (root == one || root == two) {
            return root;
        }
        TreeNode ll = lowestCommonAncestor(root.left, one, two);
        TreeNode lr = lowestCommonAncestor(root.right, one, two);
        if (ll != null && lr != null) {
            return root;
        }
        return ll == null ? lr : ll;
    }
    
}
