package com.alating.alo.leetcode.tree;

public class IsBalanced {

    public boolean isBalanced(TreeNode root) {

        if(root==null ){
            return true;
        }

        int left=getHeight(root.left);
        int right=getHeight(root.right);

        return (Math.abs(left-right)<=1) && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root){

        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }

        return Math.max(getHeight(root.left),getHeight(root.right))+1;

    }

    public static void main(String args[]){

        System.out.println(new IsBalanced().isBalanced(new TreeNode().getLevelTreeNode(new Integer[]{1,2,3,4,5,6,7,8})));
    }
}
