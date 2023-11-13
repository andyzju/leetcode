package com.alating.alo.leetcode.tree;

public class IsSubTree {


    private boolean isSameTree(TreeNode a,TreeNode b){

        if(a==null && b==null){
            return true;
        }

        if(a==null || b==null){
            return false;
        }

        return a.val==b.val && isSameTree(a.left,b.left) && isSameTree(a.right,b.right);

    }

    public  boolean isSubTree(TreeNode a,TreeNode b){

        if(b==null || a==null){
            return false;
        }

        if(isSameTree(a,b)){
            return true;
        }

        return isSubTree(a.left,b) || isSubTree(a.right,b);
    }

}
