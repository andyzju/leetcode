package com.alating.alo.leetcode.tree;

import java.util.*;

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res=new LinkedList<List<Integer>>();

        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);


        boolean leftToRig=true;

        while(!queue.isEmpty()){

            LinkedList<Integer> ele=new LinkedList<Integer>();

            // 这一层的访问
            int size=queue.size();

            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();

                if(leftToRig){
                    ele.offerLast(cur.val);
                }else{
                    ele.offerFirst(cur.val);
                }

                if(cur.left!=null){
                    queue.add(cur.left);
                }

                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }

            res.add(new ArrayList<>(ele));
            leftToRig=!leftToRig;
        }

        return res;

    }
}
