package com.alating.alo.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
 *
 *
 */
public class IsCompleteTree {

    /**
     * 1. 数组中的位置 和 树的节点是否一致
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {


        if(root==null){
            return false;
        }

        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        ArrayList<TreeNode> arr=new ArrayList<TreeNode>();

        root.val=1;
        queue.add(root);
        int maxCode=0;

        // 层次遍历，重新设置val
        // 最大的val 值是否和 数据大小一致
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();

            maxCode=Math.max(maxCode,cur.val);

            arr.add(cur);

            if(cur.left!=null){

                cur.left.val=2*cur.val;
                queue.add(cur.left);
            }

            if(cur.right!=null){
                cur.right.val=2*cur.val+1;
                queue.add(cur.right);
            }
        }

        return maxCode==arr.size();
    }

    public static void main(String args[]){

        TreeNode root=new TreeNode().getLevelTreeNode(new Integer[]{1,2,3,4,5,6});

        System.out.println(new IsCompleteTree().isCompleteTree(root));
    }
}
