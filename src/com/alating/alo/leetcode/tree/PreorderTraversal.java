package com.alating.alo.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 *
 * 二叉树的前序遍历
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res=new ArrayList<Integer>();

        if(root==null){
            return res;
        }

        res.add(root.val);

        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));

        return res;

    }
}
