package com.class10;

public class NumNodesLeft {
    static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        // store the number of nodes in the left subtree
        int numNodesLeft;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public void numNodesLeft(TreeNode root) {
        numNodes(root);
    }

    private int numNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // leftNum is the # of nodes in subtree of the root.left
        int leftNum = numNodes(root.left);
        // rightNum is the # of nodes in the subtree of root.right
        int rightNum = numNodes(root.right);
        root.numNodesLeft = leftNum;
        return leftNum + rightNum + 1;
    }
    
}
