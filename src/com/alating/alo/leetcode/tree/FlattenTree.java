package com.alating.alo.leetcode.tree;


import java.util.*;

/**
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 *
 */
public class FlattenTree {

    /**
     * 前序遍历树
     *
     * 通过stack存储
     * 先存储右子树
     * 再存储左子树
     *
     */


    /**
     * 将二叉树展开
     *
     * 通过stack的方式，压入根，然后压入右子树、压入左子树
     *
     * 完美
     *
     *  其实就是前序遍历，然后通过pre指针传递进行
     * @param root
     */
    public void flatten(TreeNode root) {

        if(root==null ){
            return;
        }

        TreeNode pre=null;
        Stack<TreeNode> stack= new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){

            TreeNode cur=stack.pop();
            if(pre!=null){
                pre.right=cur;
                pre.left=null;
            }

            // 如下是前序遍历的基础
            if(cur.right!=null){
                stack.add(cur.right);
            }

            if(cur.left!=null){
                stack.add(cur.left);
            }

            pre=cur;
        }

    }

    public static void main(String args[]){

    }
}
