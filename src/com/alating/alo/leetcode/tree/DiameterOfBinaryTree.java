package com.alating.alo.leetcode.tree;

public class DiameterOfBinaryTree {

    int ans=0;
    /**
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {

        if(root==null){
            return 0;
        }

        depth(root);

        return ans-1;
    }

    public int depth(TreeNode root){

        if(root==null){
            return 0;
        }

        if(root.left==null && root.right==null){
            return 1;
        }

        int l=depth(root.left);
        int r=depth(root.right);
        ans=Math.max(ans,l+r+1);

        return Math.max(l,r)+1;
    }
}
