package com.alating.alo.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最大宽度
 *
 * https://leetcode.cn/problems/maximum-width-of-binary-tree/
 */
public class WidthOfBinaryTree {


    class TreeNodeExt{
        private TreeNode node;
        private int depth;
        private int pos;

        public TreeNodeExt(TreeNode node,int depth,int pos){
            this.node=node;
            this.depth=depth;
            this.pos=pos;
        }
    }
    /**
     *
     * @param root
     * @param widIdx
     */
    private int levelVisit(TreeNode root,int widIdx){

        if(root==null){
            return 0;
        }

        Queue<TreeNodeExt> queue=new LinkedList<TreeNodeExt>();
        queue.add(new TreeNodeExt(root,0,1));

        int depth=0;
        int left=1;
        int max=0;
        while(!queue.isEmpty()){

            TreeNodeExt cur=queue.poll();

            if(cur.node.left!=null){
                queue.add(new TreeNodeExt(cur.node.left,cur.depth+1,2*cur.pos));
            }

            if(cur.node.right!=null){
                queue.add(new TreeNodeExt(cur.node.right,cur.depth+1,2*cur.pos+1));
            }

            // 判断某层面的开始位置
            if(depth!= cur.depth){  //访问某个层次节点的最左节点时候
                depth=cur.depth;
                left=cur.pos;
            }

            max=Math.max(max, cur.pos-left+1);
        }
        return max;
    }

    public int widthOfBinaryTree(TreeNode root) {

        if(root==null){
            return 0;
        }

        return levelVisit(root,1);

    }


    public static void main(String args[]){

        TreeNode root=new TreeNode().getLevelTreeNode(new Integer[]{1,2,3,4,5,6,7});

        System.out.println(new WidthOfBinaryTree().widthOfBinaryTree(root));
    }
}
