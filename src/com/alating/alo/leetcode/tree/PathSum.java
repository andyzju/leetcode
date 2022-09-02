package com.alating.alo.leetcode.tree;

import com.alating.alo.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {


//    private void dfs(TreeNode root,int tempSum,int targetSum){
//        if(root==null){
//            return;
//        }
//
//        tempSum+=root.val;
//
//
//    }
//
//    /**
//     *  采用递归的方式进行
//     * @param root
//     * @param targetSum
//     * @return
//     */
//    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//
//        dfs(root,0,targetSum);
//
//    }

    public static void main(String args[]){

        TreeNode root=new TreeNode().getLevelTreeNode(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});

        new TreeNode().levelVisit(root);
        //System.out.println(new PathSum().pathSum(root,22));
    }
}
