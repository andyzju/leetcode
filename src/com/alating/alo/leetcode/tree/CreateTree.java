package com.alating.alo.leetcode.tree;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * 从前序与中序遍历序列构造二叉树
 *
 * 1. 还有一种方法需要重新实现；
 */
public class CreateTree {

    HashMap<Integer,Integer> idxMap=new HashMap<Integer,Integer>();
    private TreeNode buildTree(int[] preorder, int preBeg,int preEnd,
                               int[] inorder, int inBeg,int inEnd){

        if(preEnd< preBeg){
            return null;
        }

        int root=preorder[preBeg];
        int inRootIdx=idxMap.get(root); // 找到根结点在中序中的位置
        int leftLen=inRootIdx-inBeg;
        int rigLen=inEnd-inRootIdx;

       TreeNode left =  buildTree(preorder,preBeg+1,preBeg+leftLen,inorder,inBeg,inRootIdx-1);
       TreeNode right=buildTree(preorder,preBeg+leftLen+1,preEnd,inorder,inRootIdx+1,inEnd);

       TreeNode rootX=new TreeNode(root);
       rootX.left=left;
       rootX.right=right;

       return rootX;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder==null || inorder==null ||
                preorder.length==0 || inorder.length==0 ){
            return null;
        }

        for(int i=0;i<inorder.length;i++){
            idxMap.put(inorder[i],i);
        }

        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }


    public static void main(String agrs[]){

        TreeNode root= new CreateTree().buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        new TreeNode().levelVisit(root);
    }
}
