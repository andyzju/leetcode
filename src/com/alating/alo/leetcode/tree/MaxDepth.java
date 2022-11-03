package com.alating.alo.leetcode.tree;

public class MaxDepth {


    private int max=0;
    public int maxDepth(TreeNode root) {

        if(root==null ){
            return 0;
        }

        int leftDept=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);

        return Math.max(leftDept,rightDepth)+1;

    }

}
