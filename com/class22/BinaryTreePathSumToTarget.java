package com.class22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.class4.TreeNode;

// the two nodes can be any nodes on the path from root to leaf
public class BinaryTreePathSumToTarget {
    public boolean exist(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // pass down the prefix of the path
        List<TreeNode> path = new ArrayList<>();
        return helper(root, path, sum);
    }

    private boolean helper(TreeNode root, List<TreeNode> path, int sum) {
        path.add(root);
        // check if there exists a subpath ended at the root node
        // the sum of the subpath is target
        int tmp = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            tmp += path.get(i).val;
            if (tmp == sum) {
                return true;
            }
        }
        if (root.left != null && helper(root.left, path, sum)) {
            return true;
        }
        if (root.right != null && helper(root.right, path, sum)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    // Method 2: similar to find a subarray sum to a target value
    public boolean existII(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Set<Integer> prefixSum = new HashSet<>();
        prefixSum.add(0);
        return helper(root, prefixSum, 0, sum);
    }

    private boolean helper(TreeNode root, Set<Integer> prefixSum, int prevSum, int target) {
        prevSum += root.val;
        if (prefixSum.contains(prevSum - target)) {
            return true;
        }
        boolean needRremove = prefixSum.add(prevSum);
        if (root.left != null && helper(root.left, prefixSum, prevSum, target)) {
            return true;
        }
        if (root.right != null && helper(root.right, prefixSum, prevSum, target)) {
            return true;
        }
        if (needRremove) {
            prefixSum.remove(prevSum);
        }
        return false;
    }
    
}
