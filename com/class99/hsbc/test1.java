package com.class99.hsbc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test1 {

    public static int[]  largestLand(int[][] houses)
	{
		int[]  answer = new int[2];
		// create a map to record position and house number
        // key: pos, val: house number
        Map<Integer, Integer> posMap = new HashMap<>();
        // create the distance array to be sorted
        int[] posArray = new int[houses.length - 1];
        System.out.println(posArray.length);
        int index = 0;

        for (int i = 1; i < houses.length; i++) {
            int[] j = houses[i];
            posMap.put(j[1], i);
            posArray[index++] = j[1];
        }

        Arrays.sort(posArray);
        int front = 0;
        int back = 0;
        int max = 0;

        for (int i = 1; i < posArray.length; i++) {
            if (posArray[i] - posArray[i - 1] > max) {
                max = posArray[i] - posArray[i - 1];
                front = posMap.get(posArray[i - 1]);
                back = posMap.get(posArray[i]);
            }
        }

        if (front > back) {
            return new int[]{back, front};
        }
		
		return new int[]{front, back};
	}

    public static int  maxScore(int[] nodeVal, int[][] edges)
	{
		int  answer = 0;
		// Write your code here
		// transform the edges into tree structure
        TreeNode root = constructTree(edges, nodeVal);
        int[] max = new int[Integer.MIN_VALUE];
        helper(root, max);
		
		return max[0];
	}

    public static int helper(TreeNode root, int[] max) {
    
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int left = helper(root.left, max);
        int right = helper(root.right, max);

        if (left * right * root.val > max[0]) {
            max[0] = left * right * root.val;
        }

        return left > right ? left : right;
        
    }

    public static TreeNode constructTree(int[][] edges, int[] nodeVal) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        
        for(int i = 0; i < edges.length; i++) {
            int[] j = edges[i];
            TreeNode cur = nodeMap.get(j[0]);
            if (cur != null) {
                cur.right = new TreeNode(nodeVal[j[0] - 1]);
                nodeMap.put(j[1], cur.right);
            } else {
                TreeNode tmp = new TreeNode(nodeVal[j[0] - 1]);
                tmp.left = new TreeNode(nodeVal[j[1] - 1]);
                nodeMap.put(j[0], tmp);
                nodeMap.put(j[1], tmp.left);
            }
        }

        return nodeMap.get(edges[0][0]);
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode (int val) {
            this.val = val;
        }
    }



    public static void main(String[] args) {
        int[][] matrix = {{5,2}, {3, 7}, {1,9}, {2, 0},{5,15}, {4,30}};
        System.out.println(Arrays.toString(largestLand(matrix)));

    }
    
}
