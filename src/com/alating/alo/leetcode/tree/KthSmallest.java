package com.alating.alo.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 *
 * 在搜索二叉树中查询最小的第k个节点
 *
 * 按照 中序二叉树查找
 *
 * 中序遍历
 */
public class KthSmallest {

    /**
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {

        if(root==null || k==0){
            return -1;
        }

        Deque<TreeNode> stack=new LinkedList<TreeNode>();
        TreeNode q=root;

        int num=1;
        while (q!=null || !stack.isEmpty()){

            while (q!=null){
                stack.push(q);
                q=q.left;
            }

            if(!stack.isEmpty()){
                TreeNode cur=stack.pop();
                if(num==k){
                    return cur.val;
                }
                q=cur.right;
                num++;
            }
        }

        return -1;

    }
}
